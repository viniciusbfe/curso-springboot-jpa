package com.vinibf.cursospring.services;

import com.vinibf.cursospring.entities.User;
import com.vinibf.cursospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findByID(Integer id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("User not found."));
    }
}
