package Test_2017_October;

import java.util.Arrays;

public class Team {

    private String name;
    ProblemResult[] problems;

    /**
     * Skapar ett lag med namnet name.
     */
    Team(String name) {
        this.name = name;
        problems = new ProblemResult[Contest.NBR_PROBLEMS];
        for (int i = 0; i < problems.length; i++) {
            problems[i] = new ProblemResult();
        }
    }

    /**
     * Returnerar lagets namn.
     */
    String getName() {
        return name;
    }

    /**
     * Registrerar att laget gjort ett försök på uppgift nbr vid tidpunkten time.
     * Om försöket är godkänt har approved värdet true.
     * nbr antas ligga inom det tillåtna intervallet.
     */
    public void registerAttempt(int nbr, int time, boolean approved) {
        problems[nbr].incNbrAttempts();
        if (approved) {
            problems[nbr].setTimeSolved(time);
        }
    }

    /**
     * Returnerar true om laget löst uppgift nbr, annars false.
     * nbr antas ligga inom det tillåtna intervallet.
     */
    public boolean solved(int nbr) {
        return problems[nbr].isSolved();
    }

    /**
     * Returnerar antal godkända uppgifter.
     */
    public int getNbrSolved() {
        int nbrSolved = 0;
        for (int i = 0; i < problems.length; i++) {
            if (problems[i].isSolved()) {
                nbrSolved++;
            }
        }
        return nbrSolved;
    }

    /**
     * Returnerar lagets sammanlagda tid för alla lösta uppgifter
     * inklusive tidstillägg.
     */
    int getTotalTime() {
        int totalTime = 0;

        for (int i = 0; i < problems.length; i++) {
            if (problems[i].isSolved()) {
                totalTime += problems[i].getTotalTime();
            }
        }
        return totalTime;
    }

    /**
     * Returnerar en sträng som beskriver lagets resultat.
     */
    public String toString() {

        //Arrays.toString calls toString method for every element inside array
        return name + " " + getNbrSolved() + " " + getTotalTime() + " " + Arrays.toString(problems);
    }
}
