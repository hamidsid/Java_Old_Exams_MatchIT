package Test_2018_October;

public class TestResult {
    private int[] points;

    /**
     * Skapar ett testresultat med de poäng som finns i vektorn points.
     */
    public TestResult(int[] points) {
        this.points = points;
    }

    /**
     * Beräknar summan av poängen i testresultatet.
     */
    public int sum() {
        int totalSum = 0;

        for (int i = 0; i < points.length; i++) {
            totalSum += points[i];
        }
        return totalSum;
    }

    /**
     * Returnerar antal uppgifter som har en poäng som överskrider level.
     */
    public int nbrApproved(int level) {
        int counter = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] > level)
                counter++;
        }
        return counter;
    }

    /**
     * Returnerar medelvärdet av poängen.
     */
    double mean() {
        return sum() / (double) points.length;
    }
}
