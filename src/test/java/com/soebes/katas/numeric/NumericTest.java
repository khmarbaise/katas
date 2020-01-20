package com.soebes.katas.numeric;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumericTest
{

    @Test
    public void emptyStringWrappedWillBeEmptyString()
    {
        double a = 200;
        double b = a / 3d;
        double c = b / 2d;
        double d = b + b + c + c;
        System.out.println( "a=" + a );
        System.out.println( "b=" + b );
        System.out.println( "c=" + c );
        System.out.println( "d=" + d );
    }

    @Test
    public void compareBigDecimal() {
        BigDecimal a = new BigDecimal(0.2d);
        BigDecimal b = new BigDecimal(String.valueOf(0.5d));
        BigDecimal c = new BigDecimal("0.5");
        BigDecimal d = new BigDecimal("0.50");
        System.out.println(a);              // 0.200000000000000011102230246251565404236316680908203125
        System.out.println(b);              // 0.2
        System.out.println(c);              // 0.2
        System.out.println(d);              // 0.20
        System.out.println(a.equals(b));    // false
        System.out.println(a.equals(c));    // false
        System.out.println(a.equals(d));    // false
        System.out.println(b.equals(c));    // true
        System.out.println(b.equals(d));    // false
        System.out.println(c.equals(d));    // false
        System.out.println(a.compareTo(b)); // 1 
        System.out.println(a.compareTo(c)); // 1
        System.out.println(a.compareTo(d)); // 1
        System.out.println(b.compareTo(c)); // 0
        System.out.println(b.compareTo(d)); // 0
        System.out.println(c.compareTo(d)); // 0
    }
}
