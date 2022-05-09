package com.sofka.back.services;

import com.sofka.back.models.TodoList;
import com.sofka.back.repositories.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository repository;

    public Iterable<TodoList> list(){
        return repository.findAll();
    }

    public TodoList save(TodoList todoList){
        return repository.save(todoList);
    }

    public void delete(Long id){
        repository.delete(get(id));
    }

    public TodoList get(Long id){
         return repository.findById(id).orElseThrow();
    }

}
