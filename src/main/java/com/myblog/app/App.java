package com.myblog.app;

import com.myblog.core.Router;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

public class App
{
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger("http");

        logger.info("Server is starting...");
        HttpServer server                     = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        server.createContext("/", new Router());
        server.setExecutor(threadPoolExecutor);
        logger.info("Server is ready to handle requests at 8080");
        server.start();
    }
}
