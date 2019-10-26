package Test_2018_April;

public class Question {
    private String question;
    private String[] answers;
    private double[] points;

    /**
     * Skapar en quizfråga med frågetexten question, svarsalternativen answers,
     * och poängen som de olika svarsalternativen ger i points
     */
    Question(String question, String[] answers, double[] points) {
        this.question = question;
        this.answers = answers;
        this.points = points;
    }

    /**
     * Skriver ut frågan och de olika svarsalternativen numrerade A,B,C...,
     * allt på varsin rad
     */
    void ask() {
        System.out.println(question);
        for (int i = 0; i < answers.length; i++) {
            System.out.println((char) ('A' + 1) + " : " + answers[i]);
        }
    }

    /**
     * Returnerar hur många poäng svarsalternativ answer (A,B,C...) ger
     */
    double getPoints(char answer) {
        for (int i = 0; i < answers.length; i++) {
            if(answers[i].charAt(0) == answer){
                return points[i];
            }
        }
        return -1;
    }
}
