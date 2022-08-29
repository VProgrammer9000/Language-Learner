package gui;

import dataHandler.DataHandler;
import main.Question;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class QuestionGui extends JPanel {
    CardLayout cardLayout;
    int currentSingleQuestion=0;
    List<Question> questionList;
    public QuestionGui(MainFrame mainFrame) {
        cardLayout=new CardLayout();
        setLayout(cardLayout);


        questionList = DataHandler.getQuestionList();
        for (int i = 0; i < questionList.size(); i++) {
            this.add(new SingleQuestionGui(questionList.get(i),this),"question" + i);
        }

        JPanel allQuestionSolvedPanel = new JPanel();
        allQuestionSolvedPanel.add(new JLabel("Alle Fragen gelöst"));
        JButton backToMenu=new JButton("Wiederholen");
        backToMenu.addActionListener(e -> mainFrame.restart());
        allQuestionSolvedPanel.add(backToMenu);
        this.add(allQuestionSolvedPanel,"finished");


        cardLayout.show(this,"question" + 0);

    }
    public void nextQuestion(){
        currentSingleQuestion++;
        if (currentSingleQuestion<questionList.size()) {
            cardLayout.show(this, "question" + currentSingleQuestion);
        }else{
            cardLayout.show(this, "finished");
        }
    }
}
