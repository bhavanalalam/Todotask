package com.example.dao;
	import com.example.dao.TodoDAO;
	import com.example.dao.Todo;
	import java.util.*;

	public class TestTodoDAO {
	    public static void main(String[] args) {
	        TodoDAO dao = new TodoDAO();

	        try {
	            
	            Todo newTodo = new Todo("Learn JDBC", "Practice DAO pattern", "2025-09-01 15:00:00", "PENDING");
	            dao.insertTodo(newTodo);
	            System.out.println("Inserted successfully!");

	      
	            List<Todo> todos = dao.selectAllTodos();
	            System.out.println("\nAll Todos:");
	            for (Todo t : todos) {
	                System.out.println(t.getId() + " | " + t.getTodoTitle() + " | " + t.getTodoStatus());
	            }

	   
	            Todo oneTodo = dao.selectTodo(1);
	            if (oneTodo != null) {
	                System.out.println("\nTodo with ID=1: " + oneTodo.getTodoTitle());
	            }

	            if (oneTodo != null) {
	                oneTodo.setTodoStatus("COMPLETED");
	                dao.updateTodo(oneTodo);
	                System.out.println("Updated Todo ID=1 to COMPLETED");
	            }


	            boolean deleted = dao.deleteTodo(2);
	            if (deleted) System.out.println("Deleted Todo with ID=2");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}