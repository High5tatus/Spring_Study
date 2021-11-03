package com.todo.model;

import java.util.ArrayList;

public interface TodoDAO {
	//추가
	public void todoInsert(Todo todo);
	
	public ArrayList<Todo> getList();
}
