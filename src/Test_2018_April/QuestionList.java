package Test_2018_April;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionList {
    ArrayList<Question> questions;

    /**
     * Skapar en tom frågelista
     */
    QuestionList() {

        questions = new ArrayList<>();
    }

    /**
     * Lägger till alla frågorna som finns i fileName i frågelistan
     */
    void readQuestionsFromFile (String fileName) { // Exist
        String[] answers ;
        double[] points;
        Scanner scan = null;
        try {
            scan = new Scanner(new File(fileName));
        }catch (FileNotFoundException e) {
            System.out.println("can not find the file.");
        }
        while (scan.hasNext()) {
            answers = new String[4];
            points = new double[4];
            String question = scan.nextLine();
            for (int i = 0; i < 4; i++) {
                answers[i] = scan.nextLine();
                points[i] = Double.parseDouble(scan.nextLine());

            }
            this.add(new Question(question, answers, points));
        }
    }

    /**
     * Lägger till en ny fråga newQuest sist i frågelistan
     */
    void add(Question newQuest) {
        questions.add(newQuest);
    }

    /**
     * Returnerar fråga qix (numrerade 0..getSize()-1)
     */
    Question get(int qix) {
        return questions.get(qix);
    }

    /**
     * Returnerar antalet frågor i frågelistan
     */
    int getSize() {
        return questions.size();
    }

    /**
     * Skriver ut fråga qix (numrerade 0..getSize()-1) och läser
     * svaret från scan, returnerar poängen som svaret gav
     */

    public double ask(int qix, Scanner scan) { //5p
        questions.get(qix).ask();
        String answerStr = scan.next();
        char answer = answerStr.charAt(0);
        double points = questions.get(qix).getPoints(answer);
        return points;
    }
}
