package com.example.a10.example.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("insecure/")
public class InsecureController {

    @GetMapping
    public void secure(@RequestParam String path, HttpServletResponse response) throws IOException {
        InputStream resource = new FileInputStream(path);
        org.apache.commons.io.IOUtils.copy(resource, response.getOutputStream());
        response.flushBuffer();
    }
}
