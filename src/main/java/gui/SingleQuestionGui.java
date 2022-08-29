package gui;

import main.Question;

import javax.swing.*;

public class SingleQuestionGui extends JPanel {
    public SingleQuestionGui(Question question) {
        JLabel fullSentenceLabel = new JLabel(question.getFullSentence());

        String[] incompleteSentence = question.getIncompleteSentence().split("_");

        JPanel incompleteSentencePanel=new JPanel();

        JLabel incompleteSentenceBeginningLabel = new JLabel(incompleteSentence[0]);
        JTextField textField = new JTextField();
        JLabel incompleteSentenceEndLabel = new JLabel(incompleteSentence[1]);

        incompleteSentencePanel.add(incompleteSentenceBeginningLabel);
        incompleteSentencePanel.add(textField);
        incompleteSentencePanel.add(incompleteSentenceEndLabel);

        this.add(fullSentenceLabel);
        this.add(incompleteSentencePanel);
    }
}
