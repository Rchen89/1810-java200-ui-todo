package ui;

import com.zzpublic.zwing.Label;
import com.zzpublic.zwing.View;
import core.Repository;
import core.TodoList;

import javax.swing.*;

public class MainView extends View {
    private TodoList list;

    private final static int paddingNormal = 10;
    private final static int cellHeight = 30;

    private Label titleLabel;
    private Label messageLabel;

    @Override
    protected void init(){
        super.init();
        list = Repository.todoList;
    }

    @Override
    protected void initSubviews(){
        super.initSubviews();

        messageLabel = new Label();

        titleLabel = new Label();
        titleLabel.setLocation(paddingNormal, paddingNormal);
        titleLabel.setSize(this.getWidth() - 2 * paddingNormal, cellHeight);
        titleLabel.setText(list.getTitle());
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel);

    }

}
