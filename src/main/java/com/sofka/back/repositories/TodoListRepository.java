package com.sofka.back.repositories;

import com.sofka.back.models.TodoList;
import org.springframework.data.repository.CrudRepository;

public interface TodoListRepository extends CrudRepository<TodoList, Long> {
}
