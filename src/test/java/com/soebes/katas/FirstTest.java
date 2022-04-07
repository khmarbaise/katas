package com.soebes.katas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FirstTest
{

    public String prettyOut( byte[] msg )
    {
        StringBuilder sb = new StringBuilder( msg.length * 2 );
        for ( int j = 1; j < msg.length + 1; j++ )
        {
            if ( j % 16 == 1 )
            {
                sb.append( System.lineSeparator() );
                sb.append( String.format( "%04d  |  ", j / 16 ) );
            }
            sb.append( String.format( "%02X ", msg[j - 1] ) );
            if ( j % 4 == 0 )
            {
                sb.append( " " );
            }
        }
        sb.append( System.lineSeparator() );
        return sb.toString();
    }

    @Test
    public void testName()
    {
        String TO_CHECK_FOR = "\15ABX\n0ACC3452345252452345";

        System.out.print( prettyOut( TO_CHECK_FOR.getBytes() ) );
        System.out.println( "TO=\"" + TO_CHECK_FOR + "\"" );
        assertThat( TO_CHECK_FOR.matches( ".+" ) ).isFalse();

    }
}
