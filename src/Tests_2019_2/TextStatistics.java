package Tests_2019_2;

import java.util.ArrayList;

public class TextStatistics {

    ArrayList<Counter> chars;

    /**
     * Skapar ett nytt register för att räkna antal förekomster för olika tecken.
     * Inledningsvis finns inga tecken registrerade.
     */
    TextStatistics() {

        chars = new ArrayList<>();
    }

    /**
     * Räknar (en förekomst av) tecknet ch. Om tecknet förekommit tidigare ökas
     * antalet förekomster med ett. Annars läggs tecknet in i registret.
     */
    public void countChar(char ch) {
        for (Counter c : chars) {
            if (c.getChar() == ch) {
                c.increase();
                return;
            }
        }
        Counter counter = new Counter(ch);
        counter.increase(); // once new char is added the counter should be increased from 0 to 1
        chars.add(counter);
    }

    /**
     * Räknar varje tecken som förekommer i strängen s.
     */
    public void count(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countChar(c);
        }

    }

    /**
     * Hämtar alla tecken som räknats, ordnade efter antal förekomster.
     * Varje tecken förekommer exakt en gång i resultatet. Det vanligaste
     * tecknet kommer först i strängen, och det ovanligaste kommer sist.
     */
    public String frequencyOrder() { // 8p
        StringBuilder sb = new StringBuilder(); // (1p) ok även utan StringBuilder
        ArrayList<Counter> sorted = new ArrayList<>();

        for (int i = 0; i < chars.size(); i++) {
            Counter toInsert = chars.get(i);
            int pos = 0;
            while (pos < sorted.size() && toInsert.getCount() < sorted.get(pos).getCount()) {
                pos++;
            }
            sorted.add(pos, toInsert);
        }
        for (Counter count : sorted) {
            sb.append(count.getChar()); // (1p)
        }
        return sb.toString(); // (1p)
    }
}
