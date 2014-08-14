package org.sigmah.shared;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class FileSlice_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static java.lang.String getFileName(org.sigmah.shared.FileSlice instance) {
    return (java.lang.String) ReflectionHelper.getField(org.sigmah.shared.FileSlice.class, instance, "fileName");
  }
  
  private static void setFileName(org.sigmah.shared.FileSlice instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSlice.class, instance, "fileName", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getFileOffset(org.sigmah.shared.FileSlice instance) {
    return (java.lang.Long) ReflectionHelper.getField(org.sigmah.shared.FileSlice.class, instance, "fileOffset");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setFileOffset(org.sigmah.shared.FileSlice instance, long value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSlice.class, instance, "fileOffset", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getFileSize(org.sigmah.shared.FileSlice instance) {
    return (java.lang.Long) ReflectionHelper.getField(org.sigmah.shared.FileSlice.class, instance, "fileSize");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setFileSize(org.sigmah.shared.FileSlice instance, long value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSlice.class, instance, "fileSize", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getMaxChunkSize(org.sigmah.shared.FileSlice instance) {
    return (java.lang.Long) ReflectionHelper.getField(org.sigmah.shared.FileSlice.class, instance, "maxChunkSize");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setMaxChunkSize(org.sigmah.shared.FileSlice instance, long value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSlice.class, instance, "maxChunkSize", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getSequenceID(org.sigmah.shared.FileSlice instance) {
    return (java.lang.Long) ReflectionHelper.getField(org.sigmah.shared.FileSlice.class, instance, "sequenceID");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setSequenceID(org.sigmah.shared.FileSlice instance, long value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSlice.class, instance, "sequenceID", value);
  }
  
  private static java.lang.String getSliceData(org.sigmah.shared.FileSlice instance) {
    return (java.lang.String) ReflectionHelper.getField(org.sigmah.shared.FileSlice.class, instance, "sliceData");
  }
  
  private static void setSliceData(org.sigmah.shared.FileSlice instance, java.lang.String value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSlice.class, instance, "sliceData", value);
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static long getSliceSize(org.sigmah.shared.FileSlice instance) {
    return (java.lang.Long) ReflectionHelper.getField(org.sigmah.shared.FileSlice.class, instance, "sliceSize");
  }
  
  @com.google.gwt.core.client.UnsafeNativeLong
  private static void setSliceSize(org.sigmah.shared.FileSlice instance, long value) 
  {
    ReflectionHelper.setField(org.sigmah.shared.FileSlice.class, instance, "sliceSize", value);
  }
  
  public static void deserialize(SerializationStreamReader streamReader, org.sigmah.shared.FileSlice instance) throws SerializationException {
    setFileName(instance, streamReader.readString());
    setFileOffset(instance, streamReader.readLong());
    setFileSize(instance, streamReader.readLong());
    setMaxChunkSize(instance, streamReader.readLong());
    setSequenceID(instance, streamReader.readLong());
    setSliceData(instance, streamReader.readString());
    setSliceSize(instance, streamReader.readLong());
    
  }
  
  public static org.sigmah.shared.FileSlice instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new org.sigmah.shared.FileSlice();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, org.sigmah.shared.FileSlice instance) throws SerializationException {
    streamWriter.writeString(getFileName(instance));
    streamWriter.writeLong(getFileOffset(instance));
    streamWriter.writeLong(getFileSize(instance));
    streamWriter.writeLong(getMaxChunkSize(instance));
    streamWriter.writeLong(getSequenceID(instance));
    streamWriter.writeString(getSliceData(instance));
    streamWriter.writeLong(getSliceSize(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return org.sigmah.shared.FileSlice_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    org.sigmah.shared.FileSlice_FieldSerializer.deserialize(reader, (org.sigmah.shared.FileSlice)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    org.sigmah.shared.FileSlice_FieldSerializer.serialize(writer, (org.sigmah.shared.FileSlice)object);
  }
  
}
