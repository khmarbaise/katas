package com.soebes.playground;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataHolderExample {
  
  private int intValue;
  private short shortValue;
  private long longValue;
  private boolean booleanValue;
  private float floatValue;
  private double doubleValue;
  
  public DataHolderExample(int intValue, short shortValue, long longValue, boolean booleanValue,
                           float floatValue, double doubleValue) {
    this.intValue = intValue;
    this.shortValue = shortValue;
    this.longValue = longValue;
    this.booleanValue = booleanValue;
    this.floatValue = floatValue;
    this.doubleValue = doubleValue;
  }
  
  private void readObject(ObjectInputStream in) throws IOException {
    this.intValue = in.readInt();
    this.shortValue = in.readShort();
    this.longValue = in.readLong();
    this.booleanValue = in.readBoolean();
    this.floatValue = in.readFloat();
    this.doubleValue = in.readDouble();
  }
  
  private void writeObject(ObjectOutputStream out) throws IOException {
    out.writeInt(intValue);
    out.writeShort(shortValue);
    out.writeLong(longValue);
    out.writeBoolean(booleanValue);
    out.writeFloat(floatValue);
    out.writeDouble(doubleValue);
  }
}
