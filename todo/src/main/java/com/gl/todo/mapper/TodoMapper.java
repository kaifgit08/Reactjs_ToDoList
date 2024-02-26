package com.gl.todo.mapper;

import com.gl.todo.dto.TodoDTO;
import com.gl.todo.entity.Todo;


public class TodoMapper {

	public static TodoDTO mapToTodoDTO(Todo todo) {
		TodoDTO dto = new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());
		return dto;
	}

	public static Todo mapToTodo(TodoDTO dto) {
		Todo todo = new Todo(dto.getId(), dto.getTitle(), dto.getDescription(), dto.isCompleted());
		return todo;
	}
}