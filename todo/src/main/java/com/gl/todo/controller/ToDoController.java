package com.gl.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.todo.dto.TodoDTO;
import com.gl.todo.entity.Todo;
import com.gl.todo.serviceimpl.ToDoServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/todo")
public class ToDoController {
	@Autowired
	ToDoServiceImpl service;

	@PostMapping
	ResponseEntity<TodoDTO> createToDo(@RequestBody TodoDTO dto) {
		service.createToDo(dto);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	ResponseEntity<TodoDTO> updateToDoById(@PathVariable("id") int id, @RequestBody TodoDTO dto) {
		System.out.println("Update method reached");
		TodoDTO d = service.updateToDoById(id, dto);
		return new ResponseEntity(d, HttpStatus.OK);
	}

	@GetMapping("{id}")
	ResponseEntity<TodoDTO> getToDoById(@PathVariable("id") int id) {
		TodoDTO d = service.getToDoById(id);
		return new ResponseEntity(d, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	ResponseEntity<Todo> deleteById(@PathVariable("id") int id) {
		service.deleteToDoByID(id);
		return new ResponseEntity("ToDo deleted successfully", HttpStatus.OK);
	}

	@GetMapping
	ResponseEntity<List<TodoDTO>> getAllToDo() {
		List<TodoDTO> list = service.getAllToDo();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PutMapping("{id}/complete")
	// @PatchMapping("{id}")
	ResponseEntity<TodoDTO> completeTodo(@PathVariable("id") int id) {
		System.out.println("Complete");
		System.out.println(id);
		TodoDTO dto = service.completeToDo(id);
		return new ResponseEntity(dto, HttpStatus.OK);
	}

	@PutMapping("{id}/in-complete")
	ResponseEntity<TodoDTO> inCompleteTodo(@PathVariable("id") int id) {
		System.out.println("In-Complete");
		System.out.println(id);
		TodoDTO dto = service.inCompleteToDo(id);
		return new ResponseEntity(dto, HttpStatus.OK);
	}

}