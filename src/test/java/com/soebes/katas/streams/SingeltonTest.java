package com.soebes.katas.streams;

import org.junit.jupiter.api.Test;

public class SingeltonTest
{

    @Test
    void testName()
    {
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println( "Instance1:" + instance1.hashCode() );
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println( "Instance2:" + instance2.hashCode() );

    }
}
