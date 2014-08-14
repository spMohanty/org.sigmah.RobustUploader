A Resumable Uploader and RObust Uploader library for GWT which was built for Sigmah as a part of Google Summer of Code 2014.

Documentation to be added !!


To run the project follow these steps ::

1) git clone https://github.com/spMohanty/org.sigmah.RobustUploader.git
2) cd org.sigmah.RobustUploader
3) mvn install
4) mvn gwt:run


You should see a very basic interface with a file upload input box. Along with buttons to Pause and Resume the Uploads.
(The server maintains state till its restarted. So as long as the server is not restarted the upload can still happen)


The approach here is to chunk the files in the client side into small chunks of 100KBs and upload them in sequence, and the server then combines them on receiving all of the chunks.


