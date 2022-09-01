package gui;

import main.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SingleQuestionGui extends JPanel {
    Question question;
    QuestionGui questionGui;
    JTextField textField;
    JLabel result;
    JButton showResult;
    JButton submitButton;
    boolean solved = false;
    boolean firstTry = true;
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

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    submit();
                }
            }
        });
        JLabel incompleteSentenceEndLabel = new JLabel(incompleteSentence[1]);

        incompleteSentencePanel.add(incompleteSentenceBeginningLabel);
        incompleteSentencePanel.add(textField);
        incompleteSentencePanel.add(incompleteSentenceEndLabel);

        JPanel resultPanel =new JPanel();
        result =new JLabel();
        resultPanel.add(result);

        JPanel buttonPanel=new JPanel();
        showResult = new JButton("Antwort zeigen");
        showResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(question.getAllResult()[0]);
                textField.setEditable(false);
                solved = true;
                result.setText("Lösung angezeigt");
                resultPanel.setForeground(Color.BLACK);
            }
        });

        submitButton = new JButton("abgeben");
        submitButton.addActionListener(e -> {
            submit();
        });

        buttonPanel.add(showResult);
        buttonPanel.add(submitButton);
        
        this.add(completeSentencePanel);
        this.add(incompleteSentencePanel);
        this.add(resultPanel);
        this.add(buttonPanel);
    }

    private void insertAnswer(){
        if (question.checkAnswer(textField.getText())){
            solved=true;
            result.setText("Richtig");
            result.setForeground(Color.GREEN);
            submitButton.setText("Nächste Frage");
            question.setSolvedCorrect(firstTry);
        }else {
            firstTry = false;
            textField.setText("");
            textField.grabFocus();
            result.setText("Falsch");
            result.setForeground(Color.RED);
        }

    }

    private void submit(){
        if (!solved){
            insertAnswer();
        }else{
            questionGui.nextQuestion();
        }
    }
}
