package com.soebes.playground;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataHolder implements Serializable {

    private int intValue;
    private long longValue;
    private float floatValue;
    private double doubleValue;
    private boolean booleanValue;
    private byte byteValue;
    private short shortValue;

    public DataHolder(int intValue, long longValue, float floatValue, double doubleValue, boolean booleanValue, byte byteValue, short shortValue) {
        this.intValue = intValue;
        this.longValue = longValue;
        this.floatValue = floatValue;
        this.doubleValue = doubleValue;
        this.booleanValue = booleanValue;
        this.byteValue = byteValue;
        this.shortValue = shortValue;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(intValue);
        out.writeLong(longValue);
        out.writeFloat(floatValue);
        out.writeDouble(doubleValue);
        out.writeBoolean(booleanValue);
        out.writeByte(byteValue);
        out.writeShort(shortValue);
    }

    private void readObject(ObjectInputStream in) throws IOException {
        intValue = in.readInt();
        longValue = in.readLong();
        floatValue = in.readFloat();
        doubleValue = in.readDouble();
        booleanValue = in.readBoolean();
        byteValue = in.readByte();
        shortValue = in.readShort();
    }
}
