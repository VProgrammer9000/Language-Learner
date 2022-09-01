package gui;

import dataHandler.DataHandler;
import main.Question;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionGui extends JPanel {
    CardLayout cardLayout;
    int currentSingleQuestion=0;
    int amountSingleQuestion =0;
    int amountFalseSingleQuestion=0;
    List<Question> questionList;
    JLabel pointsLabel;
    List<SingleQuestionGui> singleQuestionGuiList= new ArrayList<>();
    public QuestionGui(MainFrame mainFrame, boolean allQuestion) {
        cardLayout=new CardLayout();
        setLayout(cardLayout);

        questionList = DataHandler.getQuestionList();
        if (allQuestion) {
            for (int i = 0; i < questionList.size(); i++) {
                singleQuestionGuiList.add(i,new SingleQuestionGui(questionList.get(i), this));
                this.add(singleQuestionGuiList.get(i), "question" + i);
            }
            amountSingleQuestion =questionList.size();
        }else{
            for (int i = 0; i < questionList.size(); i++) {
                if (!questionList.get(i).getSolvedCorrect()){

                    singleQuestionGuiList.add(amountSingleQuestion,new SingleQuestionGui(questionList.get(i), this));
                    this.add(singleQuestionGuiList.get(amountSingleQuestion), "question" + amountSingleQuestion);
                    amountSingleQuestion++;
                }
            }
        }

        JPanel allQuestionSolvedPanel = new JPanel(new BorderLayout());

        JPanel firstLine=new JPanel();

        firstLine.add(new JLabel("Alle Fragen gelöst"));

        JButton restartSolvedWrongButton=new JButton("Wiederholen falsche");
        restartSolvedWrongButton.addActionListener(e -> mainFrame.restartAllWrong());
        firstLine.add(restartSolvedWrongButton);

        JButton restartButton=new JButton("Wiederholen");
        restartButton.addActionListener(e -> mainFrame.restart());
        firstLine.add(restartButton);
        allQuestionSolvedPanel.add(firstLine, BorderLayout.NORTH);

        JPanel secondLine = new JPanel();
        pointsLabel = new JLabel();
        secondLine.add(pointsLabel);
        allQuestionSolvedPanel.add(secondLine, BorderLayout.CENTER);

        this.add(allQuestionSolvedPanel,"finished");


        cardLayout.show(this,"question" + 0);

    }
    public void nextQuestion(){
        currentSingleQuestion++;
        if (currentSingleQuestion<amountSingleQuestion) {
            cardLayout.show(this, "question" + currentSingleQuestion);
            singleQuestionGuiList.get(currentSingleQuestion).textField.grabFocus();
        }else{
            cardLayout.show(this, "finished");
            for (int i = 0; i < questionList.size(); i++) {
                if(!questionList.get(i).getSolvedCorrect()){
                    amountFalseSingleQuestion++;
                }
            }
            pointsLabel.setText("Punkte: "+ (amountSingleQuestion - amountFalseSingleQuestion)  + " / " + amountSingleQuestion);
        }
    }
    public void resetAllQuestion(){
        for (Question question:questionList) {
            question.setSolvedCorrect(false);
        }
    }
}
