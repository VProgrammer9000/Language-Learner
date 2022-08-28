package Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DataHandler.DataHandler;

public class Menu extends JPanel {
    MainFrame mainFrame;
    JComboBox questionComboBox;
    JComboBox answerComboBox;

    public Menu(MainFrame mainFrame) {
        this.mainFrame=mainFrame;
        JPanel questionPanel=new JPanel();
        JLabel questionLabel = new JLabel("Question with");
        questionComboBox = new JComboBox(DataHandler.getQuestionLanguages());
        questionComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerComboBox =new JComboBox(DataHandler.getQuestionLanguages((String) questionComboBox.getSelectedItem()));
            }
        });

        questionPanel.add(questionLabel);
        questionPanel.add(questionComboBox);
        add(questionPanel);



        JPanel answerPanel=new JPanel();
        JLabel answerLabel = new JLabel("Answer with");
        answerComboBox = new JComboBox();
        answerComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                questionComboBox =new JComboBox(DataHandler.getQuestionLanguages((String) answerComboBox.getSelectedItem()));
            }
        });

        answerPanel.add(answerLabel);
        answerPanel.add(answerComboBox);
        add(answerPanel);

        JButton continueButton=new JButton("-->");
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.openQuestion();
            }
        });
    }
}
