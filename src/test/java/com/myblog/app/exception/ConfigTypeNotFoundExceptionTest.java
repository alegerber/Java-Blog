package com.myblog.app.exception;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigTypeNotFoundExceptionTest {

    @Test
    public void ExceptionTest()
    {
        Throwable exception = new ConfigTypeNotFoundException("test");
        assertEquals(exception.getMessage(), "Type test not present");
    }
}
