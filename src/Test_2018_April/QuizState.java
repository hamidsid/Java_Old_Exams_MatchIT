package Test_2018_April;

public class QuizState {

    private int[] counts;
    private double[] means;

    /**
     * Skapar en databas för nbrQuestions frågor som håller ordning på
     * antal gånger en fråga besvarats och dess medelpoäng
     */
    public QuizState(int nbrOfQuestions) {
        counts = new int[nbrOfQuestions];
        means = new double[nbrOfQuestions];
    }

    /**
     * Returnerar antal frågor i quizen
     */
    public int getSize() {
        return counts.length;
    }

    /**
     * Returnerar hur många gånger frågan qix besvarats
     */
    public int getCount(int qix) {
        return counts[qix];
    }

    /**
     * Returnerar medelpoängen för frågan qix
     */
    public double getMean(int qix) {
        return means[qix];
    }

    /**
     * Noterar att frågan qix är besvarad en gång till med poängen points
     */
    public void addResult(int qix, double points) { //3p
        counts[qix] += 1; //as the question is asked one more time
        means[qix] = (means[qix] * (counts[qix] - 1) + points) / counts[qix];
    }

    /**
     * Returnerar numret på den obesvarade fråga som har lägst nummer,
     * returnerar getSize() om det inte finns några obesvarade frågor
     */
    private int indexOfFirstCountZero() {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                return i;
            }
        }
        return getSize();
    }

    /**
     * Returnerar numret på den fråga som har lägst medelvärde just nu,
     * om två frågor har samma medelvärde väljs den med lägst nummer
     */
    private int indexOfMinMean() {
        double max = Double.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < means.length; i++) {
            if (means[i] < max) {
                max = means[i];
                index = i;
            }
        }
        return index;
    }

    public int nextQuestionIndex() {
        int zi = indexOfFirstCountZero();
        if (zi < getSize()) {
            return zi;
        } else {
            return indexOfMinMean();
        }
    }

}
