
package com.example.dao;

import java.sql.*;
import java.util.*;
import com.example.dao.Todo;

public class TodoDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/todo_tasks";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_TODO =
        "INSERT INTO todo_items(todo_title, todo_desc, todo_datatime, todo_status) VALUES (?, ?, ?, ?)";
    private static final String SELECT_TODO_BY_ID =
        "SELECT id, todo_title, todo_desc, todo_datatime, todo_status FROM todo_items WHERE id = ?";
    private static final String SELECT_ALL_TODOS =
        "SELECT * FROM todo_items";
    private static final String DELETE_TODO =
        "DELETE FROM todo_items WHERE id = ?";
    private static final String UPDATE_TODO =
        "UPDATE todo_items SET todo_title=?, todo_desc=?, todo_datatime=?, todo_status=? WHERE id=?";

    public TodoDAO() {}

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertTodo(Todo todo) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_TODO)) {
            ps.setString(1, todo.getTodoTitle());
            ps.setString(2, todo.getTodoDesc());
            ps.setString(3, todo.getTodoDateTime());
            ps.setString(4, todo.getTodoStatus()); // ENUM string
            ps.executeUpdate();
        }
    }

   
    public Todo selectTodo(int id) throws SQLException {
        Todo todo = null;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_TODO_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTodoTitle(rs.getString("todo_title"));
                todo.setTodoDesc(rs.getString("todo_desc"));
                todo.setTodoDateTime(rs.getString("todo_datatime"));
                todo.setTodoStatus(rs.getString("todo_status"));
            }
        }
        return todo;
    }

   
    public List<Todo> selectAllTodos() throws SQLException {
        List<Todo> todos = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_TODOS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo();
                todo.setId(rs.getInt("id"));
                todo.setTodoTitle(rs.getString("todo_title"));
                todo.setTodoDesc(rs.getString("todo_desc"));
                todo.setTodoDateTime(rs.getString("todo_datatime"));
                todo.setTodoStatus(rs.getString("todo_status"));
                todos.add(todo);
            }
        }
        return todos;
    }

    public boolean updateTodo(Todo todo) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_TODO)) {
            ps.setString(1, todo.getTodoTitle());
            ps.setString(2, todo.getTodoDesc());
            ps.setString(3, todo.getTodoDateTime());
            ps.setString(4, todo.getTodoStatus());
            ps.setInt(5, todo.getId());
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    public boolean deleteTodo(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_TODO)) {
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}