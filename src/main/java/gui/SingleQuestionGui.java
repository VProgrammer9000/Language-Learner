package gui;

import main.Question;

import javax.swing.*;
import java.awt.*;

public class SingleQuestionGui extends JPanel {
    Question question;
    QuestionGui questionGui;
    JTextField textField;
    JLabel result;
    JButton submitButton;
    boolean solved = false;
    public SingleQuestionGui(Question question,QuestionGui questionGui) {
        this.question = question;
        this.setLayout(new GridLayout(4,1));
        this.questionGui = questionGui;
        JPanel completeSentencePanel=new JPanel();
        JLabel completeSentenceLabel = new JLabel(question.getFullSentence());
        completeSentencePanel.add(completeSentenceLabel);

        String[] incompleteSentence = question.getIncompleteSentence().split("_");

        JPanel incompleteSentencePanel=new JPanel();
        JLabel incompleteSentenceBeginningLabel = new JLabel(incompleteSentence[0]);
        textField = new JTextField(10);
        textField.grabFocus();
        JLabel incompleteSentenceEndLabel = new JLabel(incompleteSentence[1]);

        incompleteSentencePanel.add(incompleteSentenceBeginningLabel);
        incompleteSentencePanel.add(textField);
        incompleteSentencePanel.add(incompleteSentenceEndLabel);

        JPanel resultPanel =new JPanel();
        result =new JLabel();
        resultPanel.add(result);

        JPanel submitPanel=new JPanel();
        submitButton = new JButton("abgeben");
        submitButton.addActionListener(e -> {
            if (!solved){
                insertAnswer();
            }else{
                questionGui.nextQuestion();
            }
        });

        submitPanel.add(submitButton);
        
        this.add(completeSentencePanel);
        this.add(incompleteSentencePanel);
        this.add(resultPanel);
        this.add(submitPanel);
    }
    private void insertAnswer(){
        if (question.checkAnswer(textField.getText())){
            result.setText("Richtig");
            result.setForeground(Color.GREEN);
            solved=true;
            submitButton.setText("Nächste Frage");
        }else {
            result.setText("Falsch");
            result.setForeground(Color.RED);
        }

    }

}
