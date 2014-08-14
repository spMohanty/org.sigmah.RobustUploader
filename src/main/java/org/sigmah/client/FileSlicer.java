package org.sigmah.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.sigmah.shared.FileSlice;
import org.sigmah.shared.RobustUploaderEvent;

import org.vectomatic.file.Blob;
import org.vectomatic.file.File;
import org.vectomatic.file.FileList;
import org.vectomatic.file.FileReader;
import org.vectomatic.file.events.ErrorEvent;
import org.vectomatic.file.events.ErrorHandler;
import org.vectomatic.file.events.LoadEndEvent;
import org.vectomatic.file.events.LoadEndHandler;

import com.google.gwt.core.shared.GWT;

public class FileSlicer {
	
	private  RobustUploaderComposite RobustUploaderCompositeInstance;
	
	protected List<org.vectomatic.file.File> sliceQueue;
	protected FileReader reader;
	protected boolean isSlicing;
	
	protected long maxSliceSize = 0x100000l; //in bytes
	protected long sliceCurrentOffset = 0; //in bytes
	protected long currentSliceID = 0;
	
	protected FileSlice currentSlice;
	
	protected boolean isPaused;
	
	public Blob blob;
	
	public long sliceEndOffset;
	
	public int chunkRollBackLength = 5; //Decides how many chunks to roll back when needed
	
	
	public org.vectomatic.file.File currentFile;//Holds the current File being uploaded
	
	protected String timestamp;// Holds the timestamp of when this was initiated. That acts as a namespace for the files being stored
	
	FileSlicer(RobustUploaderComposite currentInstance)
	{
		RobustUploaderCompositeInstance = currentInstance; //Acts as the manager of all different classes
		
		this.isPaused = false;
		isSlicing = false;
		
		sliceQueue = new ArrayList<File>();
		
		// Create a file reader a and queue of files to read.
		// UI event handler will populate this queue by calling queueFiles()
		reader = new FileReader();
		reader.addLoadEndHandler(new LoadEndHandler() {
			
			/**
			 * This handler is invoked when FileReader.readAsText(),
			 * FileReader.readAsBinaryString() or FileReader.readAsArrayBuffer()
			 * successfully completes
			 */
			@Override
			public void onLoadEnd(LoadEndEvent event) {
				if (reader.getError() == null) {
										
					//Entry point !! Start upload of chunks one by one !!
					currentFile = sliceQueue.get(0);			
					
					currentSlice.setSliceData(reader.getStringResult());					
					
					if(RobustUploaderCompositeInstance.getFileSlicer().isPaused == false) {

					RobustUploaderCompositeInstance.uploadSlice(currentSlice);
					
										
						currentFile = sliceQueue.get(0);
						
						if( sliceCurrentOffset == currentFile.getSize() ) {
							isSlicing = false;
						}
						else {
							isSlicing = doNextSlice(sliceQueue.get(0));
						}
					
						if (!isSlicing) {
							sliceQueue.remove(0);
							sliceNextFile();
						}		
					
					} else {
						//read the same blob again to keep the event loop on
						readBlob(sliceQueue.get(0));
					}
					
					
				} else {
	                    		//System.out.println("FileReader error: " + reader.getError().toString());
	                    		
	                    		HashMap<String, String> dataObject = new HashMap();
	                    		dataObject.put("message", "UPLOAD FAILED");
	                    		RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_FAIL, dataObject));

	            		}
			}
		});

		reader.addErrorHandler(new ErrorHandler() {
			/**
			 * This handler is invoked when FileReader.readAsText(),
			 * FileReader.readAsBinaryString() or FileReader.readAsArrayBuffer()
			 * fails
			 */
			@Override
			public void onError(ErrorEvent event) {
				if (sliceQueue.size() > 0) {
					
					//Stop slicing this file and remove it from the queue, go on
					//to the next file
					isSlicing = false;
					
					sliceQueue.remove(0);
					sliceNextFile();
				}
			}
		});
	}
	
	/**
	 * Adds a collection of file the queue and begin processing them
	 * @param files
	 * The file to process
	 */
	public void sliceFiles(FileList files) 
	{
		for (File file : files) {
			
			sliceQueue.add(file);
			
			HashMap<String, String> dataObject = new HashMap();
			dataObject.put("message", "UPLOAD START");
			RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_START, dataObject));

			
		}
		// Start processing the queue
		sliceNextFile();
	}
	
	/**
	 * Slices the next file in the queue. 
	 */
	private void sliceNextFile() 
	{
		timestamp = Long.toString(System.currentTimeMillis()); //Adds as unique marker for every file

		if (sliceQueue.size() > 0) {
			
			File file = sliceQueue.get(0);
			
			sliceCurrentOffset = 0;
        		currentSliceID = 0;
        	
			if( doNextSlice(file) == false ) {
				sliceNextFile();
			}
		}
	}
	
	private boolean doNextSlice(File file)
	{
		currentSliceID++;
		
		//Make currentSlice
		 sliceEndOffset = 0x0;

        	//If the remainder of the file is smaller than the max currentSlice, read the rest
        	if( sliceCurrentOffset + maxSliceSize >= file.getSize()  ) {
        		sliceEndOffset = (long)file.getSize();
        	}
        	else {
        		sliceEndOffset = sliceCurrentOffset + maxSliceSize;
	        }

		currentSlice = new FileSlice();
        	currentSlice.setFileName(timestamp+"_"+file.getName());
        	currentSlice.setSequenceID(currentSliceID);
        	currentSlice.setFileOffset(sliceCurrentOffset);
        	currentSlice.setMaxChunkSize(maxSliceSize);
		currentSlice.setFileSize(file.getSize());
		currentSlice.setSliceSize(sliceEndOffset - sliceCurrentOffset);
		
		return readBlob(file);
	}
	
	public void rollBack() {
		//Roll Back 5 chunks to restart the download
		if(currentSliceID > chunkRollBackLength){
			currentSliceID -= chunkRollBackLength;			
		}else {
			currentSliceID = 0;
		}
		sliceCurrentOffset = maxSliceSize*(currentSliceID);
		
		
		HashMap<String, String> dataObject = new HashMap();
		dataObject.put("message", "ROLLING BACK TO SLICE-ID :: "+currentSliceID + " to ensure Data integrity");
		RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_PAUSED, dataObject));

		
		doNextSlice(currentFile);
		
		
	}
	
	public boolean readBlob(File file){
		 blob = file.slice(sliceCurrentOffset, sliceEndOffset);

     	if( blob != null ) {
			reader.readAsBinaryString(blob);

			// Send currentSlice
			sliceCurrentOffset = sliceEndOffset;

			return true;
		} 
     	return false;
	}
	
	public boolean isPaused(){
		return this.isPaused;
	}
	
	public void pause(){
		isPaused = true;
		
		HashMap<String, String> dataObject = new HashMap();
		dataObject.put("message", "UPLOAD PAUSED");
		RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_PAUSED, dataObject));

	}
	
	public void unPause(){
		isPaused = false;
		
		HashMap<String, String> dataObject = new HashMap();
		dataObject.put("message", "UPLOAD RESUMED");
		RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_RESUMED, dataObject));

	}
}
