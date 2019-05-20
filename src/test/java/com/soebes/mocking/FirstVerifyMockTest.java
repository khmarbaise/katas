package com.soebes.mocking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class FirstVerifyMockTest {

    public class XYZ {
        public void method() {
            System.out.println("Hello World.");
        }
    }

    @Test
    void firstMockTest() {
        XYZ mock = mock(XYZ.class);

        verify(mock, Mockito.atLeastOnce()).method();
    }
    // verifyThat( recorderService).called().once().secondListener();

}
