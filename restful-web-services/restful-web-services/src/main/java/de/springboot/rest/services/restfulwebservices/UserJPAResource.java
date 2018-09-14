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

//    @Autowired
//    private UserDaoService userDaoService;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

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

    @DeleteMapping("/users/delete/{id}")
    public void deleteUser(@PathVariable Integer id) throws Exception {
         this.repository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User created = this.repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable Integer id,@RequestBody Post post) throws Exception {
        Optional<User> user = this.repository.findById(id);
        if (!user.isPresent()) {
            throw new Exception("id : ");
        }

        User savedUSer=user.get();

        post.setUser(savedUSer);
        postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePosts(@PathVariable Integer id) throws Exception {
        Optional<User> userPosts = this.repository.findById(id);
        if (!userPosts.isPresent()) {
            throw new Exception("id : ");
        }
        return userPosts.get().getPostList();

    }

    @GetMapping("/internalized")
    public String internalization() throws Exception {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
