package com.soebes.playground;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class TheBestClassEver {

  private final byte byteValue;
  private final short shortValue;
  private final int intValue;
  private final long longValue;
  private final float floatValue;
  private final double doubleValue;
  private final boolean booleanValue;
  private final char charValue;

  public TheBestClassEver(byte byteValue, short shortValue, int intValue, long longValue, float floatValue,
                          double doubleValue, boolean booleanValue, char charValue) {
    this.byteValue = byteValue;
    this.shortValue = shortValue;
    this.intValue = intValue;
    this.longValue = longValue;
    this.floatValue = floatValue;
    this.doubleValue = doubleValue;
    this.booleanValue = booleanValue;
    this.charValue = charValue;
  }

  private void write(ObjectOutputStream os) throws IOException {
    os.writeByte(byteValue);
    os.writeShort(shortValue);
    os.writeInt(intValue);
    os.writeLong(longValue);
    os.writeFloat(floatValue);
    os.writeDouble(doubleValue);
    os.writeBoolean(booleanValue);
    os.writeChar(charValue);

  }
}
