package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.TodoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class TodoListRepositoryImplTest {
    private HikariDataSource dataSource;
    private TodoListRepository repository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        repository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        TodoList todoList = new TodoList();
        todoList.setTodo("Akbar");

        repository.add(todoList);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
