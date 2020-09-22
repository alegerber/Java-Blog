package com.myblog.app.controller;

import com.myblog.core.AbstractController;
import com.myblog.core.http.Response;
import com.myblog.core.http.TemplateResponse;

public class IndexController extends AbstractController {
    public Response indexAction() {


        return new TemplateResponse("home");
    }
}
