package main;

public class Question {
    private String fullSentence;
    private String incompleteSentence;
    private String[] allResult;

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
