package com.example.a10.example.service.controller;

import com.example.a10.example.service.util.Util;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("secure/")
public class SecureController {


    @Value("${A10.path.root}")
    private String pathRoot;

    @GetMapping
    public void secure(@RequestParam String url, HttpServletResponse response){
        try{
            String path = this.pathRoot.concat(url);
            if(Boolean.TRUE.equals(Util.validatePath(url)) &&
                    Boolean.TRUE.equals(Util.existsFile(path)))
            {
                try(InputStream resource = new FileInputStream(path)){
                    IOUtils.copy(resource, response.getOutputStream());
                    response.flushBuffer();
                }
            }else{
                throw new NoSuchElementException();
            }
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
