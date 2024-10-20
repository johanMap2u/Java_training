package com.in28minutes.rest.webservices.restfull_web_services.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    private final UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }


    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id:"+id);
        return user;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        service.save(user);
    }

    @PostMapping("/error/users")
    public ResponseEntity<User> createUserEntity(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        URI location =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
         System.out.println("Attempting to delete user with id: " + id);

        boolean isDeleted = service.deleteById(id);

        if (isDeleted) {
            System.out.println("Successfully deleted user with id: " + id);
            return ResponseEntity.noContent().build();
        } else {
            System.out.println("User with id: " + id + " not found for deletion");
            return ResponseEntity.notFound().build();
        }
    }
}
