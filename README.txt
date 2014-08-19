A Resumable Uploader and RObust Uploader library for GWT which was built for Sigmah as a part of Google Summer of Code 2014.

Documentation to be added !!


To run the project follow these steps ::

1) git clone https://github.com/spMohanty/org.sigmah.RobustUploader.git
2) cd org.sigmah.RobustUploader
3) mvn install
4) Create a folder called "DataStore" inside Tomcats bin folder and give it correct permissions so that it is writable by Tomcat.
4) mvn gwt:run


You should see a very basic interface with a file upload input box. Along with buttons to Pause and Resume the Uploads.
(The server maintains state till its restarted. So as long as the server is not restarted the upload can still happen)


The approach here is to chunk the files in the client side into small chunks of 100KBs and upload them in sequence, and the server then combines them on receiving all of the chunks.


Basic Usage ::

import org.sigmah.client.RobustUploaderComposite;
import org.sigmah.shared.RobustUploaderEvent;
import org.sigmah.shared.RobustUploaderEventHandler;


RobustUploaderComposite RobustUploaderCompositeInstance = new RobustUploaderComposite();
RootPanel.get().add(RobustUploaderCompositeInstance);


String downLoadToken=null;

//Event Handlers for all major events
RobustUploaderCompositeInstance.mainBus.addHandler(RobustUploaderEvent.TYPE, new RobustUploaderEventHandler(){
		public void onEvent(RobustUploaderEvent event){

		if(event.getEventType() == RobustUploaderUtils.ROBUST_UPLOADER_EVENTS.UPLOAD_SUCCESSFUL){
		downloadToken = event.getDataObject().get("DOWNLOAD_TOKEN");
		}
		//Other Supported Events
		// UPLOAD_START, 
		// UPLOAD_SUCCESSFUL, 
		// UPLOAD_FAIL, 
		// UPLOAD_PAUSED, 
		// UPLOAD_RESUMED, 
		// UPLOAD_CONNECTION_DISRUPTED, //Sleep for 5 seconds and then try again !!        
		// UPLOAD_CHUNK_START, 
		// UPLOAD_ROLLBACK, // Required to be sure that we didnot loose any data !!
		//UPLOAD_CHUNK_RESPONSE_RECEIVED

		}
		});

//To Pause/Resume the Upload manually for some reason you can use ::
RobustUploaderCompositeInstance.pause();
RobustUploaderCompositeInstance.resume();




//To get the file stream corresponding to the token once the upload is finished 
import org.sigmah.shared.Downloader;
File f = Downloader.DownloadFileFromToken(downloadToken);

// This approach is interesting because this completely separates the Upload and Storage from the Data Privacy/Protection layer.
// For now I use only the filesystem as the Data Store, but the architecture allows us to have adapters for other forms of data storages (Amazon S3, In-Memory, etc)
// and someone can use this library to just upload the file using this library, and the internally before serving the file again can do their own layer of access checks before 
// giving it to the users
