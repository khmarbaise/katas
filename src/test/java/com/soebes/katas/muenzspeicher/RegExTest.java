package com.soebes.katas.muenzspeicher;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RegExTest
{

    static final Pattern REG = Pattern.compile( "1\\.(0|[1-9][0-9]*)(\\.(0|[1-9][0-9]*))*" );

    static Stream<Arguments> createExpectedResults()
    {
        return Stream.of( 
            Arguments.of( "000.000.000.000", false ),
            Arguments.of( "00.00.0.0", false ),
            Arguments.of( "1.0.2.3", true ),
            Arguments.of( "1.0.212.3", true ),
            Arguments.of( "1.0.212.301", true ),
            Arguments.of( "1.01.212.301", false ),
            Arguments.of( "1.01.2.3", false ),
            Arguments.of( "1.100.02.3", false ),
            Arguments.of( "1.10.0", true ),
            Arguments.of( "1.10", true ),
            Arguments.of( "1.20", true ),
            Arguments.of( "1.10.100.10", true )
        );
    }

    @ParameterizedTest(name = "{index} string:\"{0}\" expected:{1}")
    @MethodSource( "createExpectedResults" )
    void testFirst(String ip, boolean expected) {
        Matcher m = REG.matcher(ip);
        assertThat( m.matches()).isEqualTo(expected);
    }
}
