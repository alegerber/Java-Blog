package com.myblog.core;

import com.myblog.core.http.Request;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.myblog.app.controller.*;

public class Router implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
//        Request request = handleRequest(exchange);

        handleResponse(exchange, null);
    }

//    private Request handleRequest(HttpExchange exchange) {
//        //return exchange.getRequestURI().toString().split("\\?")[1].split("=")[1];
//    }

    private void handleResponse(HttpExchange exchange, Request request)  throws  IOException {
        OutputStream outputStream = exchange.getResponseBody();
        String[] splittedUri      = exchange.getRequestURI().toString().split("/");
        String controllerName;
        String methodName;

        if (0 == splittedUri.length) {
            controllerName = "index";
            methodName     = "index";
        } else if (2 == splittedUri.length) {
            controllerName = splittedUri[1];
            methodName     = "index";
        } else {
            controllerName = splittedUri[1];
            methodName     = splittedUri[2];
        }

        controllerName = controllerName.substring(0,1).toUpperCase() + controllerName.substring(1).toLowerCase() + "Controller";
        methodName     = methodName + "Action";

        String content = invokeController(controllerName, methodName);

        exchange.sendResponseHeaders(200, content.length());
        outputStream.write(content.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private String invokeController(String controllerName, String methodName) {
        try {
            Class<?> c              = Class.forName(controllerName);
            Object objectToInvokeOn = c.getConstructor().newInstance();
            Method method           = c.getDeclaredMethod(methodName);

            return (String) method.invoke(objectToInvokeOn, new Object[0]);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
