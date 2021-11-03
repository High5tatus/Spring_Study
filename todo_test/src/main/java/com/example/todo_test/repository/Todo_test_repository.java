package com.example.todo_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_test.model.Todo_test;

public interface Todo_test_repository extends JpaRepository<Todo_test, Long> {

	public List<Todo_test> findBySubjectContaining(String subject);
}
