package Test_2018_April;

import java.util.Random;
import java.util.Scanner;

public class QuizControl {

    public static void main(String[] args) { //10p
        QuestionList ql = new QuestionList(); //1p
        ql.readQuestionsFromFile("MyQuiz.txt"); //1p
        QuizState qs = new QuizState(ql.getSize()); //1p
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int total = ql.getSize();
        for (int i = 0; i < total / 2; i++) { //2p
            int nbr = rand.nextInt(total);
            double p = ql.ask(nbr, scan);
            qs.addResult(nbr, p);
        }
        for (int i = 0; i < total * 2; i++) { //2p
            int nbr = qs.nextQuestionIndex();
            double p = ql.ask(nbr, scan);
            qs.addResult(nbr, p);
        }
        System.out.println("Frågan med högst medelpoäng:"); //3p
        int best = 0;
        for (int i = 1; i < total; i++) {
            if (qs.getMean(i) > qs.getMean(best)) {
                best = i;
            }
        }
        ql.get(best).ask();
        System.out.println("Medelpoäng: " + qs.getMean(best));
    }
}
