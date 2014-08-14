package org.sigmah.shared;

import java.util.HashMap;

import org.sigmah.client.RobustUploaderUtils;
import org.sigmah.shared.RobustUploaderEventHandler;
import com.google.gwt.event.shared.GwtEvent;


import org.sigmah.client.RobustUploaderUtils.ROBUST_UPLOADER_EVENTS;

// The object of this class will be sent through the event bus when RobustUploaderEvent is fired
public class RobustUploaderEvent extends GwtEvent<RobustUploaderEventHandler>{

	public static Type<RobustUploaderEventHandler> TYPE = new Type<RobustUploaderEventHandler>();
	
        // This is the only data that we intend to pass right now in the event object
	private String message;
	private HashMap dataObject;
	
	private RobustUploaderUtils.ROBUST_UPLOADER_EVENTS eventtype;
	
	public RobustUploaderEvent(RobustUploaderUtils.ROBUST_UPLOADER_EVENTS eventtype, HashMap dataObject){
		this.dataObject = dataObject;
		this.eventtype = eventtype;
	}
	
	public HashMap getDataObject(){
		return this.dataObject;
	}
	
	@Override
	protected void dispatch(RobustUploaderEventHandler handler) {
		handler.onEvent(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<RobustUploaderEventHandler> getAssociatedType() {
		return TYPE;
	}

	public RobustUploaderUtils.ROBUST_UPLOADER_EVENTS getEventType() {
		return this.eventtype;
	}
}