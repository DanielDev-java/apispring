package com.workshopspring.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workshopspring.curso.entities.User;
import com.workshopspring.curso.repositories.UserRepository;
import com.workshopspring.curso.services.exceptions.DatabaseException;
import com.workshopspring.curso.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id,User user){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity,user);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);

        }
    }

    private void updateData(User entitiy, User user) {
        entitiy.setName(user.getName());
        entitiy.setEmail(user.getEmail());
        entitiy.setPhone(user.getPhone());
    }
}
