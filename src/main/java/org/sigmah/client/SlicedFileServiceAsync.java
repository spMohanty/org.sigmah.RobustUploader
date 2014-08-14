package org.sigmah.client;

import org.sigmah.shared.FileSlice;
import org.sigmah.shared.FileSliceResponse;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>SlicedFileService</code>.
 */
public interface SlicedFileServiceAsync {
	void sendSlice(FileSlice input, AsyncCallback<FileSliceResponse> callback)
			throws IllegalArgumentException;
}
