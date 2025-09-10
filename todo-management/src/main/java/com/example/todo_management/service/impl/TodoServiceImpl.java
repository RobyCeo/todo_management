package com.example.todo_management.service.impl;

import com.example.todo_management.dto.TodoDto;
import com.example.todo_management.entity.Todo;
import com.example.todo_management.repository.TodoRepository;
import com.example.todo_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // convert TodoDto into Todo Jpa Entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        //Todo Jpa Entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert Todo Jpa entity object into TodoDto
        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(savedTodo.getId());
        savedTodoDto.setTitle(savedTodo.getTitle());
        savedTodoDto.setDescription(savedTodo.getDescription());
        savedTodoDto.setCompleted(savedTodo.isCompleted());
        return savedTodoDto;
    }
}
