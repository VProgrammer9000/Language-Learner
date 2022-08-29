package dataHandler;

import main.Question;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataHandler {
    //TODO Add JSON File
    private static final List<Question> questionList = new ArrayList<>();

    public static void init(){
        readQuestionListJSON();
    }

    public static List<Question> getQuestionList() {
        return questionList;
    }

    private static void readQuestionListJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(System.getProperty("user.dir")+ "/data/question_eng_ger.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            Question[] questions = objectMapper.readValue(jsonData, Question[].class);
            Collections.addAll(questionList, questions);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
