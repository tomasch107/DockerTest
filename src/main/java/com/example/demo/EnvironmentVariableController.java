package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EnvironmentVariableController {
    @GetMapping("")
    public String showEnvironmentVariables(){
        String contetVar = System.getenv().get("CONTET");
        String dockerContainerId = System.getenv().get("HOSTNAME");

        return "contet: " + contetVar + " <br> containerId:" + dockerContainerId;
    }

    public String execCmd(String cmd) {

        java.util.Scanner s = null;
        try {
            s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s != null && s.hasNext() ? s.next() : "";
    }
}
