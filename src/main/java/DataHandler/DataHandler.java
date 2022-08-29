package DataHandler;

import Main.Question;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    //TODO Add JSON File
    private static List<Question> questionList = new ArrayList<>();
    private static List<String> questionLanguages = new ArrayList<>();
    private static List<String> answerLanguages = new ArrayList<>();

    public static List<Question> getQuestionList() {
        return questionList;
    }

    public static String[] getQuestionLanguages() {
        return listToArray(questionLanguages);
    }

    public static String[] getQuestionLanguages(String selectedAnswerLanguage) {
        return listToArray(questionLanguages);//TODO
    }

    public static String[] getAnswerLanguages() {
        return listToArray(answerLanguages);
    }

    public static String[] getAnswerLanguages(String selectedQuestionLanguage) {
        return listToArray(answerLanguages); //TODO
    }

    private static String[] listToArray(List<String> list){
        String[] str = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }
        return str;
    }


    private static void readQuestionListJSON() {
        List <Question> questionList = new ArrayList<>();
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get("PATH"));// TODO Path
            ObjectMapper objectMapper = new ObjectMapper();
            Question[] questions = objectMapper.readValue(jsonData, Question[].class);
            for (Question question : questions) {
                questionList.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
