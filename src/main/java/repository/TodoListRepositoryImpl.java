package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository {
    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull() {
        // check data full?
        var isFull = true;
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                // model still not full?
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void reSizeIfFull() {
        // if full is true? then index length array resize 2*
        if (isFull()) {
            var temp = data;
            data = new TodoList[data.length * 2];

            for (var i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todoList) {
        reSizeIfFull();

        // add to position index == null
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (var i = (number - 1); i < data.length; i++) {
                // hmmm misal panjang nya 10 - 1 = 9, maka index ke 9 = null index ke 9 = nullindex ke 9 = nullindex ke 9 = nullindex ke 9 = null
                // jika i itu 10 - 1 = 9, panjang array 10 - 1 = 9 maka
                // model[9] = null, okay make sense, ngerti ngerti!
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    // else nya itu maka si model[8] value nya = model[8 + 1]
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
