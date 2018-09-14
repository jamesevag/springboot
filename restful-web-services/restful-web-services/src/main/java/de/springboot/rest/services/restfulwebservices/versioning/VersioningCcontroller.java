package de.springboot.rest.services.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningCcontroller {

    @GetMapping("/personV1")
    public PersonV1 personV1(){
        return new PersonV1("dimi");
    }
    @GetMapping("/personV2")
    public PersonV2 personV2(){
        return new PersonV2(new Name("james","evag"));
    }

    //http://localhost:8080/person/param?version=1
    @GetMapping(value="/person/param",params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("dimi");
    }

    //http://localhost:8080/person/param?version=2
    @GetMapping(value="/person/param",params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("james","evag"));
    }

    //http://localhost:8080/person/param?version=1
    @GetMapping(value="/person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("dimi");
    }

    //http://localhost:8080/person/param?version=2
    @GetMapping(value="/person/header",headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("james","evag"));
    }

    //http://localhost:8080/person/param?version=1
    @GetMapping(value="/person/produces",produces = "application/vnd.company.app-v1+json")
    public PersonV1 producerV1(){
        return new PersonV1("dimi");
    }

    //http://localhost:8080/person/param?version=2
    @GetMapping(value="/person/produces",produces = "application/vnd.company.app-v2+json")
    public PersonV2 producerV2(){
        return new PersonV2(new Name("james","evag"));
    }
}
