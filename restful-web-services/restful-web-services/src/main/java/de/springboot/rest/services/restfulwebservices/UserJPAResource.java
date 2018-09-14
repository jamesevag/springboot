package de.springboot.rest.services.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private UserRepository repository;

    @Autowired
    MessageSource messageSource;

    @GetMapping("/users")
    public List<User> retriveAllUsers() {
        return this.repository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> retriveUser(@PathVariable Integer id) throws Exception {
        Optional<User> user = this.repository.findById(id);
        if (user == null) {
            throw new Exception("id : ");
        }
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) throws Exception {
        User user = this.userDaoService.deleteById(id);
        if (user == null) {
            throw new Exception("id : ");
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User created = this.userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @GetMapping("/internalized")
    public String internalization() throws Exception {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
