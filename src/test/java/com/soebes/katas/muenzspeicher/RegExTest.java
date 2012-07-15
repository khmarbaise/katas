package com.soebes.katas.muenzspeicher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RegExTest {

    public static final Pattern REG = Pattern.compile("1\\.(0|[1-9][0-9]*)(\\.(0|[1-9][0-9]*))*");

    @DataProvider(name = "test")
    public Object[][] createData() {
     return new Object[][] {
       { "000.000.000.000", false },
       { "00.00.0.0", false },
       { "1.0.2.3", true },
       { "1.0.212.3", true },
       { "1.0.212.301", true },
       { "1.01.212.301", false },
       { "1.01.2.3", false },
       { "1.100.02.3", false },
       { "1.10.0", true },
       { "1.10", true },
       { "1.20", true },
       { "1.10.100.10", true },
     };
    }

    @Test(dataProvider = "test")
    public void testFirst(String ip, boolean expected) {
        Matcher m = REG.matcher(ip);
        assertThat(m.matches()).isEqualTo(expected);
    }
}
