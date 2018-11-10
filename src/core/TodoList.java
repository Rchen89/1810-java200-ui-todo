package core;

import java.util.LinkedList;
import java.util.List;

public class TodoList {
    private String title;
    private List<TodoItem> items = new LinkedList<>();
    // TodoItem
    // Text:String
    // DueTime: Date

    public List<TodoItem> getItems(){
        return items;
    }

    public void add(TodoItem item){
        items.add(item);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
