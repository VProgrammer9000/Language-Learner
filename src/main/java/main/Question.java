package main;

public class Question {
    private String fullSentence;
    private String incompleteSentence;
    private String[] allResult;
    private boolean solvedCorrect = false;

    public String getFullSentence() {
        return fullSentence;
    }

    public String getIncompleteSentence() {
        return incompleteSentence;
    }

    public String[] getAllResult() {
        return allResult;
    }

    public boolean getSolvedCorrect() {
        return solvedCorrect;
    }

    public void setSolvedCorrect(boolean solvedCorrect) {
        this.solvedCorrect = solvedCorrect;
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
