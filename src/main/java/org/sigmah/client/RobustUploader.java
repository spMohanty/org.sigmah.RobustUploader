package org.sigmah.client;

import org.sigmah.client.RobustUploaderComposite;
import org.sigmah.shared.RobustUploaderEvent;
import org.sigmah.shared.RobustUploaderEventHandler;

import org.vectomatic.file.FileList;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class RobustUploader implements EntryPoint {

	private RobustUploaderComposite RobustUploaderCompositeInstance;

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  
	  	RobustUploaderCompositeInstance = new RobustUploaderComposite();
		RootPanel.get().add(RobustUploaderCompositeInstance);
		
		RobustUploaderCompositeInstance.mainBus.addHandler(RobustUploaderEvent.TYPE, new RobustUploaderEventHandler(){
				public void onEvent(RobustUploaderEvent event){
					DOM.getElementById("logmessages").setInnerHTML("<li>"+event.getDataObject().get("message")+"</li>"+DOM.getElementById("logmessages").getInnerHTML());
					GWT.log("Event message !! : "+event.getDataObject().get("message"));
				}
		});
		
  }
}
