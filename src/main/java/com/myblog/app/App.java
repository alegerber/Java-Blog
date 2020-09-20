package com.myblog.app;

import com.myblog.core.Router;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class App
{
    public static void main(String[] args) throws IOException {
        HttpServer server                     = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        server.createContext("/", new Router());
        server.setExecutor(threadPoolExecutor);
        server.start();
    }
}
