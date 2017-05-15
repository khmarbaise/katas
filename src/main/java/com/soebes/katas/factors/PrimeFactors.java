package com.soebes.katas.factors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors
{

    public static List<Integer> factorsOf( int n )
    {
        List<Integer> result = new ArrayList<>();

        int divider = 2;
        while ( n > 1 )
        {
            while ( n % divider == 0 )
            {
                result.add( divider );
                n /= divider;
            }
            divider++;
        }

        return result;
    }

}
