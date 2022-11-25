package com.example.a10.example.service.controller;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${A10.path.root}")
    private String pathRoot;

    @GetMapping
    public void insecure(@RequestParam String url, HttpServletResponse response) throws IOException {
        try{
            InputStream resource = new FileInputStream(pathRoot+url);
            org.apache.commons.io.IOUtils.copy(resource, response.getOutputStream());
            response.flushBuffer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
