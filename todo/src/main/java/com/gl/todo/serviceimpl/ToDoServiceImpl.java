package com.gl.todo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.todo.dto.TodoDTO;
import com.gl.todo.entity.Todo;
import com.gl.todo.exception.ResourceNotFoundException;
import com.gl.todo.mapper.TodoMapper;
import com.gl.todo.repository.ToDoRepository;
import com.gl.todo.service.ToDoService;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	ToDoRepository repository;

	@Override
	public TodoDTO createToDo(TodoDTO dto) {
		Todo t = TodoMapper.mapToTodo(dto);

		return TodoMapper.mapToTodoDTO(repository.save(t));
	}

	@Override
	public TodoDTO getToDoById(int id) {
		Todo t = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo is not exists with a given id: " + id));

		return TodoMapper.mapToTodoDTO(t);
	}

	@Override
	public TodoDTO updateToDoById(int id, TodoDTO dto) {
		Todo d = null;
		d = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ToDo is not exists with a given id: " + id));
		d.setTitle(dto.getTitle());
		d.setDescription(dto.getDescription());
		d.setCompleted(dto.isCompleted());
		return TodoMapper.mapToTodoDTO(repository.save(d));
	}

	@Override
	public List<TodoDTO> getAllToDo() {
		List<Todo> list = repository.findAll();
		return list.stream().map((todo) -> TodoMapper.mapToTodoDTO(todo)).collect(Collectors.toList());
	}

	@Override
	public void deleteToDoByID(int id) {
		Todo t = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo is not exists with a given id: " + id));
		repository.deleteById(id);

	}

	@Override
	public TodoDTO completeToDo(int id) {
		Todo todo = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo is not exists with a given id: " + id));
		;
		todo.setCompleted(true);
		return TodoMapper.mapToTodoDTO(repository.save(todo));
	}

	@Override
	public TodoDTO inCompleteToDo(int id) {
		Todo todo = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Todo is not exists with a given id: " + id));
		;
		todo.setCompleted(false);
		return TodoMapper.mapToTodoDTO(repository.save(todo));
	}

}