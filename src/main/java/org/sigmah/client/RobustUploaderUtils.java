package org.sigmah.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

public class RobustUploaderUtils {
	public static EventBus EVENT_BUS = GWT.create(SimpleEventBus.class);
	
	public enum ROBUST_UPLOADER_EVENTS {
		UPLOAD_START, //Done
		UPLOAD_SUCCESSFUL, //Done
		UPLOAD_FAIL, //Done
		UPLOAD_PAUSED, //Done
		UPLOAD_RESUMED, // Done
		UPLOAD_CONNECTION_DISRUPTED, //Done :: Sleep for 5 seconds and then try again !! 
		UPLOAD_CHUNK_START, //DONE
		UPLOAD_ROLLBACK, //Done :: Required to be sure that we didnot loose any data !!
		UPLOAD_CHUNK_RESPONSE_RECEIVED, //DONE 
	}
}
