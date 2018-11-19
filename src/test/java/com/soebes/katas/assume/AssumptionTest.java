package com.soebes.katas.assume;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class AssumptionTest
{

    @Test
    void testName()
    {
        assertThat( true ).isTrue();
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void thisTestIsRunningOnlyOnJDK11()
    {
        assertThat( true ).isTrue();
    }

    @Test
    void assumptionTest()
    {
        assumeTrue( false, "Jenkins version is less than 2.0");
        assertThat( true ).isTrue();
    }
}
