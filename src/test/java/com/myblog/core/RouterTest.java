package com.myblog.core;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RouterTest {


//    @Test
//    public void handleTest()
//    {
//        try {
//            HttpHandler router = mock(Router.class);
//            HttpExchange exchange = mock(HttpExchange.class);
//            URI uri = mock(URI.class);
//            OutputStream outputStream = mock(OutputStream.class);
//
//            when(uri.toString()).thenReturn("");
//            when(exchange.getRequestURI()).thenReturn(uri);
//            when(exchange.getResponseBody()).thenReturn(outputStream);
//            when(router.invokeController()).thenReturn(outputStream);
//
//            verify(outputStream, times(1)).write("test".getBytes());
//
//            router.handle(exchange);
//        } catch (IOException $e){
//            fail();
//        }
//    }

}
