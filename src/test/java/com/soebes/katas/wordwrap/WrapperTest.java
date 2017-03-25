package com.soebes.katas.wordwrap;

import static com.soebes.katas.wordwrap.Wrapper.wrap;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class WrapperTest
{

    @Test
    public void emptyStringWrappedWillBeEmptyString()
    {
        assertThat( wrap( "", 1 ) ).isEqualTo( "" );
    }

    @Test
    public void stringShorterThanColumnStringDoesNotWrap()
    {
        assertThat( wrap( "test", 10 ) ).isEqualTo( "test" );
    }

    @Test
    public void splitOneWordWithoutSpaces()
    {
        assertThat( wrap( "word", 2 ) ).isEqualTo( "wo\nrd" );
    }

    @Test
    public void splitOneWordManyTimesWithoutSpaces()
    {
        assertThat( wrap( "abcdefghi", 3 ) ).isEqualTo( "abc\ndef\nghi" );
    }

    @Test
    public void wrapWellBeforeWordBoundary()
    {
        assertThat( wrap( "word word", 3 ) ).isEqualTo( "wor\nd\nwor\nd" );
    }

    @Test
    public void wrapJustBeforeWordBoundary()
    {
        assertThat( wrap( "word word", 4 ) ).isEqualTo( "word\nword" );
    }

    @Test
    public void wrapOnWordBoundary()
    {
        assertThat( wrap( "word word", 5 ) ).isEqualTo( "word\nword" );
    }

    @Test
    public void wrapAfterWordBoundary()
    {
        assertThat( wrap( "word word", 6 ) ).isEqualTo( "word\nword" );
    }

}
