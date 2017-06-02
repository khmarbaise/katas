package com.soebes.katas.factors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors
{

    public static List<Integer> of( final int n )
    {
        List<Integer> result = new ArrayList<>();
        int divider = 2;
        int remainder = n;
        while ( remainder > 1 )
        {
            while ( remainder % divider == 0 )
            {
                result.add( divider );
                remainder /= divider;
            }
            divider++;
        }
        return result;
    }

}
