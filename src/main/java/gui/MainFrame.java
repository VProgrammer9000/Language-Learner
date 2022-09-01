package gui;

import dataHandler.DataHandler;
import main.Question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {
    CardLayout cardLayout=new CardLayout();
    JPanel mainPanel=new JPanel(cardLayout);
    QuestionGui questionGui;

    public MainFrame(){
        setTitle("Language Lerner");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);

        DataHandler.init();


        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        mainPanel.setBackground(Color.cyan);
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));

        add(mainPanel);

        questionGui= new QuestionGui(this, true);
        mainPanel.add(questionGui,"question");

        setVisible(true);
    }


    public void restart(){
        questionGui = new QuestionGui(this,true);
        mainPanel.add(questionGui,"question");
        cardLayout.show(mainPanel,"question");
        questionGui.resetAllQuestion();
    }

    public void restartAllWrong(){
        questionGui = new QuestionGui(this, false);
        mainPanel.add(questionGui, "question");
        cardLayout.show(mainPanel,"question");
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
