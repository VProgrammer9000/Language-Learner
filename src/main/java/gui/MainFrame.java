package gui;

import dataHandler.DataHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    CardLayout cardLayout=new CardLayout();
    JPanel mainPanel=new JPanel(cardLayout);

    public MainFrame(){
        setTitle("Language Lerner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);

        DataHandler.init();

        mainPanel.setBackground(Color.cyan);
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        add(mainPanel);
        mainPanel.add(new QuestionGui(this),"question");

        setVisible(true);
    }


    public void restart(){
        mainPanel.add(new QuestionGui(this),"question");
        cardLayout.show(mainPanel,"question");
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
