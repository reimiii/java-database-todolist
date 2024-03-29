package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        System.out.println("TODO-LIST");
        for (TodoList todo : model) {
            System.out.println(todo.getId() + ". " + todo.getTodo());
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("Success add Todo: " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if (success) {
            System.out.println("Success remove todo: " + number);
        } else {
            System.out.println("Failed remove todo: " + number);
        }
    }
}
