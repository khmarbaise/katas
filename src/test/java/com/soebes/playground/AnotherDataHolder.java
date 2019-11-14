package com.soebes.playground;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AnotherDataHolder {

  private byte byteValue;
  private int intValue;
  private short shortValue;
  private long longValue;
  private boolean booleanValue;
  private float floatValue;
  private double doubleValue;

  public AnotherDataHolder(byte byteValue, int intValue, short shortValue, long longValue, boolean booleanValue,
                           float floatValue, double doubleValue) {
    this.byteValue = byteValue;
    this.intValue = intValue;
    this.shortValue = shortValue;
    this.longValue = longValue;
    this.booleanValue = booleanValue;
    this.floatValue = floatValue;
    this.doubleValue = doubleValue;
  }


  private void readObject(ObjectInputStream out) throws IOException {
    byteValue = out.readByte();
    intValue = out.readInt();
    shortValue = out.readShort();
    longValue = out.readLong();
    booleanValue = out.readBoolean();
    floatValue = out.readFloat();
    doubleValue = out.readDouble();

  }

  private void writeObject(ObjectOutputStream out) throws IOException {
    out.writeByte(byteValue);
    out.writeInt(intValue);
    out.writeShort(shortValue);
    out.writeLong(longValue);
    out.writeBoolean(booleanValue);
    out.writeFloat(floatValue);
    out.writeDouble(doubleValue);
  }
}
