package com.myblog.app.controller;

import com.myblog.core.http.Response;
import com.myblog.core.http.TemplateResponse;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class IndexControllerTest {

    @Test
    public void indexActionTest()
    {
        Response response = (new IndexController()).indexAction();
        assertThat(response, instanceOf(TemplateResponse.class));
    }
}
