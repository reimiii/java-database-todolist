import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import util.DatabaseUtil;
import view.TodoListView;

import javax.sql.DataSource;


public class MainV2 {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodoListRepository repository = new TodoListRepositoryImpl(dataSource);
        TodoListService service = new TodoListServiceImpl(repository);
        TodoListView view = new TodoListView(service);

        view.showTodoList();
    }
}