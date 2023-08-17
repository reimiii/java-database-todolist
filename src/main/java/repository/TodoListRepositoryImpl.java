package repository;

import entity.TodoList;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository {
    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {
        String sql = "select id, todo from todolist;";

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            List<TodoList> todoLists = new ArrayList<>();

            while (resultSet.next()) {
                TodoList list = new TodoList();
                list.setId(resultSet.getInt("id"));
                list.setTodo(resultSet.getString("todo"));

                todoLists.add(list);
            }

            return todoLists.toArray(new TodoList[]{});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(TodoList todoList) {
        String sql = "insert into todolist(todo) values (?);";

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, todoList.getTodo());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isExist(Integer number) {
        String sql = "select id from todolist where id = ?";

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, number);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean remove(Integer number) {
        if (isExist(number)) {
            String sql = "delete from todolist where id = ?";

            try (Connection connection = dataSource.getConnection()) {
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, number);
                    statement.executeUpdate();

                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return false;
        }
    }
}
