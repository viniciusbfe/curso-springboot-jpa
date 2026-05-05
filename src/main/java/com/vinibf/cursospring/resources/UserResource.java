package com.vinibf.cursospring.resources;

import com.vinibf.cursospring.entities.User;
import com.vinibf.cursospring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByID(@PathVariable Integer id){
        User user = service.findByID(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user){
        user = service.insertUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user){
        user = service.updateUser(id, user);
        return ResponseEntity.ok().body(user);
    }

}
