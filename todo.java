package com.example.dao;

public class Todo {
    private int id;
    private String todoTitle;
    private String todoDesc;
    private String todoDateTime;
    private String todoStatus;  

    public Todo() {}

    public Todo(int id, String todoTitle, String todoDesc, String todoDateTime, String todoStatus) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.todoDesc = todoDesc;
        this.todoDateTime = todoDateTime;
        this.todoStatus = todoStatus;
    }

    public Todo(String todoTitle, String todoDesc, String todoDateTime, String todoStatus) {
        this.todoTitle = todoTitle;
        this.todoDesc = todoDesc;
        this.todoDateTime = todoDateTime;
        this.todoStatus = todoStatus;
    }

  
    public int getId() { 
    	return id;
    	}
    public void setId(int id) { 
    	this.id = id;
    	}
    public String getTodoTitle() {
    	return todoTitle; 
    	}

    public void setTodoTitle(String todoTitle) { 
    	this.todoTitle = todoTitle; 
    	}

    public String getTodoDesc() { 
    	return todoDesc; 
    	}
    public void setTodoDesc(String todoDesc) { 
    	this.todoDesc = todoDesc; 
    	}

    public String getTodoDateTime() {
    	return todoDateTime; 
    	}
    public void setTodoDateTime(String todoDateTime) {
    	this.todoDateTime = todoDateTime; 
    	}

    public String getTodoStatus() {
    	return todoStatus; 
    	}
    public void setTodoStatus(String todoStatus) {
    	this.todoStatus = todoStatus; 
    	}
}
