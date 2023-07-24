package test.service;

import entity.TodoList;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodList() {
//        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0] = new TodoList("Malas");
        todoListRepository.data[1] = new TodoList("Tidak Malas");
        todoListRepository.data[2] = new TodoList("Lumayan Malas");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        todoListService.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service = new TodoListServiceImpl(repository);

        service.addTodoList("Makan gorengan");
        service.addTodoList("Makan balabala");
        service.addTodoList("Makan cau");

        service.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository repository = new TodoListRepositoryImpl();
        TodoListService service = new TodoListServiceImpl(repository);

        service.addTodoList("Makan gorengan");
        service.addTodoList("Makan balabala");
        service.addTodoList("Makan cau");

        service.showTodoList();

        service.removeTodoList(4);
        service.removeTodoList(2);

        service.showTodoList();

        service.removeTodoList(2);

        service.showTodoList();

        service.removeTodoList(2);

        service.showTodoList();

        service.removeTodoList(1);

        service.showTodoList();
    }
}
