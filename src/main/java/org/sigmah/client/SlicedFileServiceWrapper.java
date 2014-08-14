package org.sigmah.client;

import java.util.HashMap;
import com.google.gwt.user.client.Timer;


import org.sigmah.shared.FileSlice;
import org.sigmah.shared.FileSliceResponse;
import org.sigmah.shared.RobustUploaderEvent;

import org.sigmah.client.Base64Utils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;



public class SlicedFileServiceWrapper {
	
	private RobustUploaderComposite RobustUploaderCompositeInstance;
	
	SlicedFileServiceWrapper(RobustUploaderComposite currentInstance){
		RobustUploaderCompositeInstance = currentInstance;
	}
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	
	private SlicedFileServiceAsync uploadService;

	public void uploadSlice(FileSlice slice)
	{
		
		/**
		 * 
		 * Two Approaches ::
		 * 
		 * 1) Send all the packets in sequence and in case we dont get response for some packets, do a few roll backs and keep trying
		 * 
		 * 2) Send the next packet ONLY after receiving the response for the first :: Too slow this one :'( :'( But guaranteed result
		 */
		

		HashMap<String, String> dataObject = new HashMap();
		dataObject.put("seq-id",Long.toString(slice.getSequenceID()));
		dataObject.put("message", "Uploading slice with sequence ID : " + dataObject.get("seq-id"));
		RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_CHUNK_START, dataObject));
	 
		
		
		if( uploadService == null )
		{
	        	uploadService = GWT.create(SlicedFileService.class);
		}
	
		AsyncCallback<FileSliceResponse> callback = new AsyncCallback<FileSliceResponse>() {
	
			public void onFailure(Throwable caught) {
				//GWT.log("Upload failure: " + caught.toString());
				
				//Fire Slice Upload Fail Event
				HashMap<String, String> dataObject = new HashMap();
				dataObject.put("message", "CONNECTION DISRUPTED   ");
				RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_CONNECTION_DISRUPTED, dataObject));
			 
				//Pause the File slicer for 5 seconds
				RobustUploaderCompositeInstance.getFileSlicer().pause();
				Timer t = new Timer() {
				      @Override
				      public void run() {
				    	  RobustUploaderCompositeInstance.getFileSlicer().unPause();
				      }
				    };
				    // Schedule the timer to run once in 5 seconds.
				    t.schedule(5000);
			}
	
			@Override
			public void onSuccess(FileSliceResponse response) {
	
				if( response == null ) {
					GWT.log("Empty response");
					
					HashMap<String, String> dataObject = new HashMap();
					dataObject.put("message", "Connection Disrupted : ");
					RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_CONNECTION_DISRUPTED, dataObject));
				 	
					RobustUploaderCompositeInstance.getFileSlicer().pause();//Pausing for 5 seconds
							
					
				    // Create a new timer that calls Window.alert().
				    Timer t = new Timer() {
				      @Override
				      public void run() {
				    	RobustUploaderCompositeInstance.getFileSlicer().unPause(); //UnPause after 5 seconds

				      }
				    };

				    // Schedule the timer to run once in 5 seconds.
				    t.schedule(5000);
				}
				else
				{
					GWT.log("Received response " + response.getSequenceID() + " for file " + response.getFileName());
					
					RobustUploaderCompositeInstance.setResponseHTML(response.getResponseMessage());
					RobustUploaderCompositeInstance.setProgress(Integer.valueOf(response.getSliceProgress()));		
					
					HashMap<String, String> dataObject = new HashMap();
					dataObject.put("seq-id",Long.toString(response.getSequenceID()));
					dataObject.put("progress", Integer.toString(response.getSliceProgress()));
					dataObject.put("message", "Received Response for slice with sequence ID : " + dataObject.get("seq-id")+" progress : "+dataObject.get("progress"));
					RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_CHUNK_RESPONSE_RECEIVED, dataObject));
				 
					
					if(response.state){
						//Also fire an upload complete event
						//Fire a Upload Complete event
						HashMap<String, String> dataObject1 = new HashMap();
						dataObject1.put("DOWNLOAD_TOKEN",new String(Base64Utils.toBase64(response.getFileName().getBytes())));
						dataObject1.put("message", "UPLOAD SUCCESSFUL  ___ DOWNLOAD_TOKEN :: "+dataObject1.get("DOWNLOAD_TOKEN"));
						RobustUploaderCompositeInstance.mainBus.fireEvent(new RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_SUCCESSFUL, dataObject1));
					 
					}
					
					// RobustUploader.instance.setResponseHTML(response.getResponseMessage());
					// RobustUploader.instance.setProgress(Integer.valueOf(response.getSliceProgress()));

				}
			}
			
		};
	            
		uploadService.sendSlice(slice, callback);
	}
	
	
}
