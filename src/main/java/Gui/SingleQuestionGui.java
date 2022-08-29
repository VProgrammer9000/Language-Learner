package Gui;

import Main.Question;

import javax.swing.*;

public class SingleQuestionGui extends JPanel {
    public SingleQuestionGui(Question question) {
        JLabel fullSentenceLabel = new JLabel(question.getFullSentence());

        String[] incompleteSentence = question.getIncompleteSentence().split("_");

        JLabel incompleteSentenceBeginningLabel = new JLabel(incompleteSentence[0]);
        JTextField textField = new JTextField();
        JLabel incompleteSentenceEndLabel = new JLabel(incompleteSentence[1]);


    }
}
