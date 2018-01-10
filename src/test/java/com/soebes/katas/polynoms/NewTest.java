package com.soebes.katas.polynoms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class NewTest
{

    // Write a function to make a derivation of a polynomial
    // 3*x^2 + 5 x + 7
    // + 5 * x^1 + 7 * x^0
    //
    //
    // 1. Question data structure ?
    // First assumption simple array...
    // 2. exponents only positive? So we start index 0 ?
    //
    @Test
    public void derivationOfConstant()
    {
        // Something Like: f(x) = 3 * X ^ 0
        // f´(x) = 0
        Integer[] polynomial = new Integer[] { 3 };
        Integer[] derivation = derivation( polynomial );
        assertThat( derivation ).hasSize( 0 );
    }

    @Test
    public void derivationOfFirstFactor()
    {
        // Something Like: f(x) = 2 * X + 7;
        // f´(x) = 2
        Integer[] polynomial = new Integer[] { 2, 7 };
        Integer[] derivation = derivation( polynomial );
        assertThat( derivation ).hasSize( 1 ).containsExactly( 2 );
    }

    @Test
    public void derivationOfTwoFactors()
    {
        // Something Like: f(x) = 3 * X ^ 2 + 2 * X + 7;
        // f´(x) = 2 * 3 * X^1 + 2
        Integer[] polynomial = new Integer[] { 3, 2, 7 };
        Integer[] derivation = derivation( polynomial );
        assertThat( derivation ).hasSize( 2 ).containsExactly( 6, 2 );
    }

    @Test
    public void derivationOfThreeFactors()
    {
        // Something Like: f(x) = 9 * X^3 + 6 * X ^ 2 + 2 * X + 7;
        // f´(x) = 9 * 3 * X ^ 2 + 6 * 2 * X + 2
        Integer[] polynomial = new Integer[] { 9, 6, 2, 7 };
        Integer[] derivation = derivation( polynomial );
        assertThat( derivation ).hasSize( 3 ).containsExactly( 27, 12, 2 );
    }

    private Integer[] derivation( Integer[] polynomial )
    {
        if ( polynomial.length > 1 )
        {
            Integer[] result = new Integer[polynomial.length - 1];

            int exponent = polynomial.length - 1;

            int index = 0;

            while ( index < result.length )
            {
                result[index] = polynomial[index] * exponent;
                index++;
                if ( exponent > 1 )
                {

                    exponent--;
                }
            }

            return result;
        }
        else
        {
            return new Integer[] {};
        }
    }

    @Test
    public void testName()
    {
        final ArrayList<Integer> a = new ArrayList<Integer>() {{ add (1); add (2); add (3); add (4); }};
        final ArrayList<Integer> b = new ArrayList<Integer>() {{ add (5); add (6); add (7); add (8); }};
        final ArrayList<Integer> c = new ArrayList<Integer>() {{ add (9); add (10); add (11); add (12); }};

        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>() {{
            add(a);
            add(b);
            add(c);
        }};
        
        printContent( x );
        ArrayList<ArrayList<Integer>> performOps = performOps( x );
        System.out.println( "----------------------" );
        printContent( performOps );
        
        System.out.println( "----------------------" );
        for (int i = 0; i < performOps.size(); i++) {
            for (int j = 0; j < performOps.get(i).size(); j++) {
                    System.out.print(performOps.get(i).get(j) + " ");
            }
        }

    }

    private void printContent (ArrayList<ArrayList<Integer>> performOps ) {
        for ( ArrayList<Integer> item : performOps )
        {
            System.out.println( "Item: " + item );
            for ( Integer innerItem : item )
            {
                System.out.println( " -> " + innerItem );
            }
        }
    }
    ArrayList<ArrayList<Integer>> performOps( ArrayList<ArrayList<Integer>> A )
    {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for ( int i = 0; i < A.size(); i++ )
        {
            B.add( new ArrayList<Integer>() );

            for ( int j = 0; j < A.get( i ).size(); j++ )
            {
                B.get( i ).add( 0 );
            }

            for ( int j = 0; j < A.get( i ).size(); j++ )
            {
                B.get( i ).set( A.get( i ).size() - 1 - j, A.get( i ).get( j ) );
            }
        }
        return B;
    }

}
