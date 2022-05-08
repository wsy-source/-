package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BaseController {

    @Autowired
    public HttpServletRequest request;

    @Autowired
    public HttpServletResponse response;
}
