import java.util.ArrayList;
import java.util.List;

public class dataHandler {
    private static List<String> firstLanguage;
    private static List<String> secondLanguage;

    public static List<String> getFirstLanguage() {
        return firstLanguage;
    }

    public static void setFirstLanguage(List<String> firstLanguage) {
        dataHandler.firstLanguage = firstLanguage;
    }

    public static List<String> getSecondLanguage() {
        return secondLanguage;
    }

    public static void setSecondLanguage(List<String> secondLanguage) {
        dataHandler.secondLanguage = secondLanguage;
    }
}
