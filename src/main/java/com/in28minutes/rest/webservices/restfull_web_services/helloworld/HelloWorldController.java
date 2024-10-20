package com.in28minutes.rest.webservices.restfull_web_services.helloworld;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {


//    @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hellow World Johan... hotreload";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Worlds");
    }

    @GetMapping(path = "/hello/path/{name}")
    public HelloWorldBean hellowowrldPathVariables(@PathVariable String name){
        return new HelloWorldBean(String.format("Testing,%s",name));

    }
}
