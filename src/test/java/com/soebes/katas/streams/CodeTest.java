package com.soebes.katas.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

public class CodeTest
{

    @Test
    void testName()
        throws IOException
    {
        
        Integer i = Integer.valueOf( 12 );
        int pi = 12;
        Double d = Double.valueOf( 12.56d );

        ByteArrayOutputStream baos = new ByteArrayOutputStream(1);

        ObjectOutputStream oos = new ObjectOutputStream( baos );

        oos.writeObject( pi );

        oos.close();

        byte[] byteArray = baos.toByteArray();

        long objectSize = ObjectSizeCalculator.getObjectSize( pi );
        System.out.println( "Size:" + objectSize );

    }
}
