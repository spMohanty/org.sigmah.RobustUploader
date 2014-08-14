package org.sigmah.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.RpcToken;
import com.google.gwt.user.client.rpc.RpcTokenException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class SlicedFileService_Proxy extends RemoteServiceProxy implements org.sigmah.client.SlicedFileServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "org.sigmah.client.SlicedFileService";
  private static final String SERIALIZATION_POLICY ="44B90526AD7C80954B50B92470FF4526";
  private static final org.sigmah.client.SlicedFileService_TypeSerializer SERIALIZER = new org.sigmah.client.SlicedFileService_TypeSerializer();
  
  public SlicedFileService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "slice", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void sendSlice(org.sigmah.shared.FileSlice input, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper helper = new com.google.gwt.user.client.rpc.impl.RemoteServiceProxy.ServiceHelper("SlicedFileService_Proxy", "sendSlice");
    try {
      SerializationStreamWriter streamWriter = helper.start(REMOTE_SERVICE_INTERFACE_NAME, 1);
      streamWriter.writeString("org.sigmah.shared.FileSlice/2789040110");
      streamWriter.writeObject(input);
      helper.finish(callback, ResponseReader.OBJECT);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
  @Override
  public SerializationStreamWriter createStreamWriter() {
    ClientSerializationStreamWriter toReturn =
      (ClientSerializationStreamWriter) super.createStreamWriter();
    if (getRpcToken() != null) {
      toReturn.addFlags(ClientSerializationStreamWriter.FLAG_RPC_TOKEN_INCLUDED);
    }
    return toReturn;
  }
  @Override
  protected void checkRpcTokenType(RpcToken token) {
    if (!(token instanceof com.google.gwt.user.client.rpc.XsrfToken)) {
      throw new RpcTokenException("Invalid RpcToken type: expected 'com.google.gwt.user.client.rpc.XsrfToken' but got '" + token.getClass() + "'");
    }
  }
}
