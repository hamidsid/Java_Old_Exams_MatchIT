package Test_2018_August;

public class PrimeList {

    private boolean[] numbers;


    PrimeList(int n) {

        numbers = new boolean[n+1];
        preparePrimeList();

    }

    private void preparePrimeList() {

        //initially assume all the numbers to be prime in the array.
        //A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = true;
        }

        for (int i = 2; i < Math.sqrt(numbers.length); i++) {

            // If number[i] is not changed, then it is a prime
            if (numbers[i]) {

                //update all multiples of p
                for (int j = 2; j * i <= numbers.length; j++) {
                    numbers[i * j] = false;
                }
            }
        }

    }

    /**
     * Skriver ut samtliga primtal som finns i primtalslistan
     */
    public void printPrimeList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < numbers.length; i++) {
            if (isPrime(i)) {
                sb.append(i + ",");
            }
        }

        //delete last space and comma
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
    }

    /**
     * Returnerar true om nbr är ett primtal som finns i primtalslistan,
     * false i alla andra fall
     */
    boolean isPrime(int nbr) {
        if (nbr > 0 && nbr < numbers.length) {
            return numbers[nbr];
        }
        return false;
    }
}
