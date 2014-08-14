package org.sigmah.client;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.vectomatic.file.FileList;


import org.sigmah.shared.FileSlice;
import org.sigmah.shared.RobustUploaderEvent;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Composite;


public class RobustUploaderComposite extends Composite {
	private FileSlicer slicer ;
	private SlicedFileServiceWrapper service ;
	private FileUploadComposite composite  ;
	
	public SimpleEventBus mainBus = new SimpleEventBus();
	
	RobustUploaderComposite(){
		slicer = new FileSlicer(this);	
		service = new SlicedFileServiceWrapper(this); 
		composite = new FileUploadComposite(this);
		
		initWidget(composite);
		
	}

	public FileUploadComposite getFileUploadComposite(){
		return composite;
	}

	public FileSlicer getFileSlicer(){
		return slicer;
	}
	public SlicedFileServiceWrapper getSlicedFileServiceWrapper(){
		return service;
	}

	
	//Interfacing Functions

	public void sliceFiles(FileList files)
	{
		slicer.sliceFiles(files);
	}
	
	public void uploadSlice(FileSlice slice)
	{
		service.uploadSlice(slice);

	}
	
	public void setResponseHTML(String html)
	{
		composite.setResponseHTMLText(html);
	}
	
	public void setProgress(Integer progress)
	{
		composite.setProgress(progress);

	}
	

}
