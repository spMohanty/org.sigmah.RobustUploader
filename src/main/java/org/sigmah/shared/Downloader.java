package org.sigmah.shared;

import java.io.File;
import org.sigmah.client.Base64Utils;

public class Downloader {
	public static File DownloadFileFromToken(String Token){
		//To-DO implement DataStore interface to enable having multiple data stores
		return new File("DataStore/"+new String(Base64Utils.fromBase64(Token)));
	}
}
