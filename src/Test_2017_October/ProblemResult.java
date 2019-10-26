package Test_2017_October;

public class ProblemResult {

    private int nbrAttempts;
    private boolean isSolved;
    private int timeSolved;

    /**
     * Skapar ett resultat för en uppgift. Från början är uppgiften olöst och
     * antal försök är 0.
     */
    public ProblemResult() {
        nbrAttempts = 0;
        isSolved = false;
    }

    /**
     * Ökar antal försök på uppgiften med ett.
     */
    public void incNbrAttempts() {
        nbrAttempts++;
    }

    /**
     * Returnerar antal försök.
     */
    public int getNbrAttempts() {
        return nbrAttempts;
    }

    /**
     * Returnerar true ifall uppgiften är löst, i annat fall false.
     */
    public boolean isSolved() {
        return isSolved;
    }

    /**
     * Registrerar att uppgiften lösts vid tidpunkten time (antal minuter efter
     * tävlingens start).
     */
    public void setTimeSolved(int time) {
        isSolved = true;
        timeSolved = time;
    }

    /**
     * Tar reda på den totala tiden det tagit att lösa uppgiften inklusive
     * tidstillägg för ej godkända försök. Om uppgiften ej är löst
     * returneras 0.
     */
    public int getTotalTime() {
        if (!isSolved) {
            return 0;
        }
        return Contest.TIME_PENALTY * (nbrAttempts - 1) + timeSolved; //because failing starts after first attempt
    }

    /**
     * Returnerar en sträng som innehåller antal försök följt av blanktecken
     * och antingen tidpunkten då korrekt lösning lämnats eller - (om
     * uppgiften ej är löst).
     * Exempel 1 - korrekt lösning efter 23 min på tredje försöket: "3 23"
     * Exempel 2 - två ej godkända försök: "2 -"
     */
    public String toString() {
        if (!isSolved) {
            return nbrAttempts + "  _";
        }
        return nbrAttempts + " " + timeSolved;
    }
}
