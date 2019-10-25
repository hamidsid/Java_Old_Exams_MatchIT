package Tests_2019_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyAnalysis {
    // Tecken i svenska språket, ordnade utifrån hur vanliga de är
    private static final String F_KLARTEXT = "EAN RTSILDOMKGVHF.UPÄBCÅÖYJXWZQ";

    /**
     * Knäcker det krypterade meddelandet m med hjälp
     * av frekvensanalys, och skriver ut det i klartext.
     */
    public static void crack(String m) {
        StringBuilder plainText = null;
        TextStatistics ts = new TextStatistics();
        ts.count(m);

        //find the freq. in the crypted msg
        String orderedEncryped = ts.frequencyOrder();

        for (int i = 0; i <m.length() ; i++) {
            char ch = m.charAt(i);

            //find the index of that char in the freq ordered list
            int index = orderedEncryped.indexOf(ch);

            System.out.print(F_KLARTEXT.charAt(index));
        }
        System.out.println();
    }


    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("encrypted.txt"));
            String s = scan.nextLine();
            FrequencyAnalysis.crack(s);
        } catch (FileNotFoundException e) {
            System.out.println("Fel: filen kunde inte läsas: " + e);
        }
    }
}

