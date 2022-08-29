package gui;

import dataHandler.DataHandler;
import main.Question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.DatabaseMetaData;
import java.util.List;

public class MainFrame extends JFrame {
    CardLayout cardLayout=new CardLayout();
    JPanel mainPanel=new JPanel(cardLayout);

    public MainFrame(){
        setTitle("Language Lerner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);

        mainPanel.setBackground(Color.cyan);
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        add(mainPanel);
        mainPanel.add(new Menu(this),"menu");
        mainPanel.add(new Menu(this),"question");

        cardLayout.show(mainPanel,"menu");

        setVisible(true);
    }

    public void openQuestion(){
        cardLayout.show(mainPanel,"question");
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
