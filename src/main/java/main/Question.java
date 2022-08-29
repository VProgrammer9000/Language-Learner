package main;

public class Question {
    private String fullSentence ="Working at Andeo is a great experience!";
    private String incompleteSentence ="Bei Andeo zu arbeiten ist eine grossartige _____ !";
    private String[] allResult = {"Erfahrung"};

    public String getFullSentence() {
        return fullSentence;
    }

    public String getIncompleteSentence() {
        return incompleteSentence;
    }

    public String[] getAllResult() {
        return allResult;
    }

    public boolean checkAnswer(String input){
        for (String result:allResult) {
            if (input.equalsIgnoreCase(result)){
                return true;
            }
        }
        return false;
    }
}
