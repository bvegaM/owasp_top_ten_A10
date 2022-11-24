package com.example.a10.example.service.controller;

import com.example.a10.example.service.util.Util;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;

@RestController
@RequestMapping("secure/")
public class SecureController {

    @GetMapping
    public void secure(@RequestParam String url, HttpServletResponse response){
        try{
            if(Util.validatePath(url)){
                try(InputStream resource = new FileInputStream(url)){
                    IOUtils.copy(resource, response.getOutputStream());
                    response.flushBuffer();
                }
            }
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
