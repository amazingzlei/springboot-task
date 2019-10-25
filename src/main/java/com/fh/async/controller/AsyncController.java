package com.fh.async.controller;

import com.fh.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    private AsyncService service;

    @RequestMapping("async")
    public String async01() {
        service.async();
        return "success";
    }
}
