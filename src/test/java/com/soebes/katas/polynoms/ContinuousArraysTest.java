package com.soebes.katas.polynoms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class ContinuousArraysTest
{

    final ArrayList<Integer> GIVEN_C = new ArrayList<Integer>()
    {
        {
            add( 1967513926 );
            add( 1540383426 );
            add( -1303455736 );
            add( -521595368 );
        }
    };

    final ArrayList<Integer> GIVEN_B = new ArrayList<Integer>()
    {
        {
            add( 0 );
            add( 0 );
            add( -1 );
            add( 0 );
        }
    };

    // 336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229,
    // -859484421
    final ArrayList<Integer> GIVEN_A = new ArrayList<Integer>()
    {
        {
            add( 336465782 );
            add( -278722862 );
            add( -2145174067 );
            add( 1101513929 );
            add( 1315634022 );
            add( -1369133069 );
            add( 1059961393 );
            add( 628175011 );
            add( -1131176229 );
            add( -859484421 );
        }
    };

    final ArrayList<Integer> GIVEN = new ArrayList<Integer>()
    {
        {
            add( 1 );
            add( 2 );
            add( 5 );
            add( -7 );
            add( 2 );
            add( 3 );
        }
    };

    public ArrayList<Integer> maxset( ArrayList<Integer> a )
    {
        ArrayList<Long> max = new ArrayList<Long>();
        max.add( 0L );
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add( new ArrayList<Integer>() );

        int index = 0;
        for ( Integer item : a )
        {
            if ( item < 0 )
            {
                index++;
                result.add( new ArrayList<Integer>() );
                max.add( 0L );
                continue;
            }

            System.out.println( "  Item: " + item );
            ArrayList<Integer> subList = result.get( index );

            Long maxValue = max.get( index );
            max.set( index, maxValue + item );
             System.out.println( "Index: " + index + " maxValue: " + max.get( index ) );

            if ( subList.size() > 0 )
            {
                Integer lastElement = subList.get( subList.size() - 1 );
                if ( item >= lastElement )
                {
                    subList.add( item );
                }
            }
            else
            {
                subList.add( item );
            }
        }
        System.out.println( "Search Max:" + max.size() );
        long resultMax = 0;
        int resultIndex = 0;
        for ( int i = 0; i < max.size(); i++ )
        {
            System.out.println( "i:" + i + " v:" + max.get( i) + " cmp " + resultMax );
            if ( max.get( i ) > resultMax )
            {
                resultIndex = i;
                resultMax = max.get( i );
            }
        }
        System.out.println( " resultIndex:" + resultIndex );
        return result.get( resultIndex );
    }

    @Test
    public void first()
    {
        System.out.println( "-------------------------------" );
        ArrayList<Integer> maxset = maxset( GIVEN );
        assertThat( maxset ).containsExactly( 1, 2, 5 );
    }

    @Test
    public void second()
    {
        System.out.println( "-------------------------------" );
        ArrayList<Integer> maxset = maxset( GIVEN_A );
        assertThat( maxset ).containsExactly( 1101513929, 1315634022 );
    }

    @Test
    public void third()
    {
        System.out.println( "-------------------------------" );
        ArrayList<Integer> maxset = maxset( GIVEN_B );
        assertThat( maxset ).containsExactly( 0, 0 );
    }
    @Test
    public void forth()
    {
        System.out.println( "-------------------------------" );
        ArrayList<Integer> maxset = maxset( GIVEN_C );
        // From my point of view the following is simply wrong (Or mistaken something?).
        // assertThat( maxset ).containsExactly( 1967513926, 1540383426  );
        assertThat( maxset ).containsExactly( 1540383426, 1967513926  );
    }
}

