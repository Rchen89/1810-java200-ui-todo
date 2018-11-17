package ui;

import com.zzpublic.zwing.Button;
import com.zzpublic.zwing.Label;
import com.zzpublic.zwing.TextField;
import com.zzpublic.zwing.View;
import core.Repository;
import core.TodoItem;
import core.TodoList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MainView extends View {
    private TodoList list;

    private final static int paddingNormal = 10;
    private final static int paddingSmall = 5;
    private final static int cellHeight = 30;
    private final static int panelHeight = 40;

    private Label titleLabel;
    private View containerView;

    private Button addButton;
    private TextField textField;


    @Override
    protected void init(){
        super.init();
        list = Repository.todoList;
    }

    @Override
    protected void initSubviews(){
        super.initSubviews();

        titleLabel = new Label();
        titleLabel.setLocation(paddingNormal, paddingNormal);
        titleLabel.setSize(this.getWidth() - 2 * paddingNormal, cellHeight);
        titleLabel.setText(list.getTitle());
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel);

        containerView = new View();
        containerView.setLocation(0, titleLabel.getY() + titleLabel.getHeight() + paddingNormal);
        containerView.setSize(this.getWidth(), this.getHeight() - containerView.getY() - paddingNormal - panelHeight);
        this.add(containerView);

        int y = titleLabel.getY() + titleLabel.getHeight() + paddingNormal;
        for (TodoItem todoItem: list.getItems()){
            Label label = new Label();
            label.setText(todoItem.getText());
            label.setLocation(paddingNormal, y);
            label.setSize(this.getWidth()-2 * paddingNormal, cellHeight);
            containerView.add(label);
            y += label.getHeight() + paddingNormal;
        }

        View inputView = new View();
        inputView.setSize(this.getWidth(),panelHeight);
        inputView.setLocation(0,this.getHeight()-inputView.getHeight()-124);
        this.add(inputView);

        addButton = new Button("add");
        addButton.setSize(100, cellHeight);
        addButton.setLocation(this.getWidth()- paddingSmall- addButton.getWidth(),paddingSmall);
        inputView.add(addButton);

        textField = new TextField();
        textField.setSize(addButton.getX() - 2 * paddingSmall, cellHeight);
        textField.setLocation(paddingSmall,paddingSmall);
        inputView.add(textField);
    }

    @Override
    protected void initEvents(){
        super.initEvents();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Update Core
                String text = textField.getText();
                TodoItem todoItem = new TodoItem();
                todoItem.setText(text);
                list.add(todoItem);
                //sync UI
                MainView.this.remove(containerView);
                //add 4 label
                //clean UI
                textField.setText("");
            }
        });
    }
}
