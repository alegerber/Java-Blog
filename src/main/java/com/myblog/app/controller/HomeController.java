package com.myblog.app.controller;

import com.myblog.core.AbstractController;
import com.myblog.core.http.Response;
import com.myblog.core.http.TemplateResponse;

public class HomeController extends AbstractController {
    public Response indexAction() {


        return new TemplateResponse("home");
    }
}
