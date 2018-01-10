package com.soebes.katas.comp;

import java.util.Comparator;

public class FirstCompXXXX
    implements Comparator<String>
{

    @Override
    public int compare( String o1, String o2 )
    {
        if ( o1.equals( o2 ) )
        {
            return 0;
        }
        else
        {
            return o1.compareTo( o2 );
        }
    }

}