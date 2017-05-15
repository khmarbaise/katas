package com.soebes.katas.factors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors
{

    public static List<Integer> factorsOf( int n )
    {
        List<Integer> result = new ArrayList<>();
        if ( n > 1 )
        {
            while ( n % 2 == 0 )
            {
                result.add( 2 );
                n /= 2;
            }
            if ( n % 3 == 0 )
            {
                result.add( 3 );
            }
            if ( n % 5 == 0 )
            {
                result.add( 5 );
            }
            if ( n % 7 == 0 )
            {
                result.add( 7 );
            }
        }
        return result;
    }

}
