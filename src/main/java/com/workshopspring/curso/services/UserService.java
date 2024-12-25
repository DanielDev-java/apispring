package com.workshopspring.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopspring.curso.entities.User;
import com.workshopspring.curso.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public User update(Long id,User user){
        User entity = repository.getReferenceById(id);
        updateData(entity,user);
        return repository.save(entity);
    }

    private void updateData(User entitiy, User user) {
        entitiy.setName(user.getName());
        entitiy.setEmail(user.getEmail());
        entitiy.setPhone(user.getPhone());
    }
}
