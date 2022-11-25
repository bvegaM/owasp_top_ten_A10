package com.example.a10.example.service.util;

import java.io.File;
import java.util.regex.Pattern;

public class Util {

    private Util() {
        throw new IllegalStateException("Utility class");
    }

    public static Boolean validatePath(String path){
        return Pattern.matches("[a-zA-Z0-9\\s.]{1,50}", path);
    }

    public static Boolean existsFile(String path){
        return new File(path).exists();
    }
}
