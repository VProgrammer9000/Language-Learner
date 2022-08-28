import java.util.Scanner;

public class LanguageLearner {
        public static Scanner sc=new Scanner(System.in);
    public LanguageLearner(){

        run();

    }

    public void run(){
        System.out.println(dataHandler.getFirstLanguage().get(0));
        System.out.println(dataHandler.getSecondLanguage());
        String input=sc.next();
        if (input.equalsIgnoreCase("")){//TODO
            System.out.println("Richtig");
        }else {
            System.out.println("Falsch");
        }
    }

    public static void main(String[] args) {
        new LanguageLearner();
    }
}
