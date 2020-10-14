package com.myblog.core.http;

import org.junit.Test;
import static org.junit.Assert.*;

public class TemplateResponseTest {

    @Test
    public void OnlyTemplateTest()
    {
        Response response = new TemplateResponse("home");
        assertTrue(response.toString().length() > 0);
    }
}
