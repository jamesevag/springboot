package de.springboot.rest.services.restfulwebservices;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @RequestMapping(method= RequestMethod.GET,path = "/helloworld")
    public  String helloWorld(){
        return "hello world";
    }

    @RequestMapping(method= RequestMethod.GET,path = "/helloworld-bean")
    public  HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello ");
    }

    @RequestMapping(method= RequestMethod.GET,path = "/helloworld/path/{name}")
    public  HelloWorldBean helloWorldPath(@PathVariable  String name){
        return new HelloWorldBean("hello path variable");
    }
}
