package gui;

import dataHandler.DataHandler;

import javax.swing.*;

public class QuestionGui extends JPanel {
    public QuestionGui() {
        DataHandler.getQuestionList().get(0);
        add(new SingleQuestionGui(DataHandler.getQuestionList().get(0)));
    }
}
