package org.sigmah.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FileSliceResponse_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getFileName(org.sigmah.shared.FileSliceResponse instance) {
    return (java.lang.String) ReflectionHelper.getField(org.sigmah.shared.FileSliceResponse.class, instance, "fileName");
  }
  
  private static void setFileName(org.sigmah.shared.FileSliceResponse instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSliceResponse.class, instance, "fileName", value);
  }
  
  private static java.lang.String getResponseMessage(org.sigmah.shared.FileSliceResponse instance) {
    return (java.lang.String) ReflectionHelper.getField(org.sigmah.shared.FileSliceResponse.class, instance, "responseMessage");
  }
  
  private static void setResponseMessage(org.sigmah.shared.FileSliceResponse instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSliceResponse.class, instance, "responseMessage", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getSequenceID(org.sigmah.shared.FileSliceResponse instance) {
    return (java.lang.Long) ReflectionHelper.getField(org.sigmah.shared.FileSliceResponse.class, instance, "sequenceID");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setSequenceID(org.sigmah.shared.FileSliceResponse instance, long value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSliceResponse.class, instance, "sequenceID", value);
  }
  
  private static int getSliceProgress(org.sigmah.shared.FileSliceResponse instance) {
    return (java.lang.Integer) ReflectionHelper.getField(org.sigmah.shared.FileSliceResponse.class, instance, "sliceProgress");
  }
  
  private static void setSliceProgress(org.sigmah.shared.FileSliceResponse instance, int value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSliceResponse.class, instance, "sliceProgress", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.sigmah.shared.FileSliceResponse instance) throws SerializationException {
    setFileName(instance, streamReader.readString());
    setResponseMessage(instance, streamReader.readString());
    setSequenceID(instance, streamReader.readLong());
    setSliceProgress(instance, streamReader.readInt());
    instance.state = streamReader.readBoolean();
    
  }
  
  public static org.sigmah.shared.FileSliceResponse instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.sigmah.shared.FileSliceResponse();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.sigmah.shared.FileSliceResponse instance) throws SerializationException {
    streamWriter.writeString(getFileName(instance));
    streamWriter.writeString(getResponseMessage(instance));
    streamWriter.writeLong(getSequenceID(instance));
    streamWriter.writeInt(getSliceProgress(instance));
    streamWriter.writeBoolean(instance.state);
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.sigmah.shared.FileSliceResponse_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.sigmah.shared.FileSliceResponse_FieldSerializer.deserialize(reader, (org.sigmah.shared.FileSliceResponse)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.sigmah.shared.FileSliceResponse_FieldSerializer.serialize(writer, (org.sigmah.shared.FileSliceResponse)object);
  }
  
}
