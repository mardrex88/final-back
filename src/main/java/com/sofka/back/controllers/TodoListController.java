package com.sofka.back.controllers;

import com.sofka.back.models.Todo;
import com.sofka.back.models.TodoList;
import com.sofka.back.services.TodoListService;
import com.sofka.back.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @CrossOrigin(origins = "http://localhost:3000")
    public class TodoListController {

        @Autowired
        private TodoListService service;
        @Autowired
        private TodoService todoService;

        @GetMapping(value = "api/list")
        public Iterable<TodoList> list(){
            return service.list();
        }

        @PostMapping(value = "api/todolist")
        public TodoList save(@RequestBody TodoList list){
            return service.save(list);
        }

        @PostMapping(value = "api/list/{id}/todo")
        public Todo add(@PathVariable("id")Long id, @RequestBody Todo todo){
            todo.setIdTodoList(id);
           return  todoService.save(todo);
        }

        @PutMapping(value = "api/list")
        public TodoList update(@RequestBody TodoList todo){
            if(todo.getId() != null){
                return service.save(todo);
            }
            throw new RuntimeException("No existe el id para actualizar");
        }

        @DeleteMapping(value = "api/{id}/list")
        public void delete(@PathVariable("id")Long id){
            service.delete(id);
        }


        @GetMapping(value = "api/{id}/list")
        public TodoList get(@PathVariable("id") Long id){
            return service.get(id);
        }

    }


