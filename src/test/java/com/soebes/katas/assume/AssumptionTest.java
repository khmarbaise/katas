package com.soebes.katas.assume;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class AssumptionTest {

    @Test
    void testName() {
        assertThat(true).isTrue();
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void thisTestIsRunningOnlyOnJDK11() {
        assertThat(true).isTrue();
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void runningOnWindowsOnly() {
        assertThat("This is the string").isEqualTo("XX");
    }

    @Test
    void assumptionTest() {
        assumeTrue(false, "Jenkins version is less than 2.0");
        assertThat(true).isTrue();
    }

}
