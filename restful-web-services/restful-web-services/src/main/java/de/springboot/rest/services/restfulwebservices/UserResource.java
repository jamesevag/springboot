package de.springboot.rest.services.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;


    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return this.userDaoService.findALl();
    }

    @GetMapping("/users/{id}")
    public User retriveUser(@PathVariable Integer id) throws Exception {
        User user= this.userDaoService.findOne(id);
        if(user==null){
            throw new Exception("id : ");
        }
        return user;
    }

    @DeleteMapping  ("/users/{id}")
    public void deleteUser(@PathVariable Integer id) throws Exception {
        User user= this.userDaoService.deleteById(id);
        if(user==null){
            throw new Exception("id : ");
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
       User created=this.userDaoService.save(user);
        URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
}
