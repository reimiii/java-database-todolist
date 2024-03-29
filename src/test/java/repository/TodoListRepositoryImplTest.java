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

    @Test
    void testRemove() {
        System.out.println(repository.remove(1));
        System.out.println(repository.remove(2));
        System.out.println(repository.remove(3));
        System.out.println(repository.remove(4));
    }

    @Test
    void testGetAll() {
        repository.add(new TodoList("Hilmi"));
        repository.add(new TodoList("Akbar"));
        repository.add(new TodoList("Muharrom"));

        TodoList[] todoLists = repository.getAll();
        for (TodoList todo : todoLists) {
            System.out.println(todo.getId() + ": " + todo.getTodo());
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
