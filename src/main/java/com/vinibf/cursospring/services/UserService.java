package com.vinibf.cursospring.services;

import com.vinibf.cursospring.entities.User;
import com.vinibf.cursospring.repositories.UserRepository;
import com.vinibf.cursospring.services.exceptions.DatabaseExcpetion;
import com.vinibf.cursospring.services.exceptions.ResourceNotFoundExcpetion;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundExcpetion(id));
    }

    public User insertUser(User user){
        return repository.save(user);
    }

    public void deleteUser(Integer id){
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundExcpetion(id);
        }

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseExcpetion("Não é possível excluir o usuário pois existem dados relacionados.");
        }
    }

    public User updateUser(Integer id, User obj) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExcpetion(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
