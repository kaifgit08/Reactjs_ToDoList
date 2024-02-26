package com.gl.todo.service;

import java.util.List;

import com.gl.todo.dto.TodoDTO;

public interface ToDoService {
	TodoDTO createToDo(TodoDTO department);

	TodoDTO getToDoById(int id);

	TodoDTO updateToDoById(int id, TodoDTO todoDTO);

	List<TodoDTO> getAllToDo();

	void deleteToDoByID(int id);

	TodoDTO completeToDo(int id);

	TodoDTO inCompleteToDo(int id);
}