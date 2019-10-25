package Tests_2019_2;

import java.util.Random;
import java.util.Scanner;

public class StreamCipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //get plaint text from user
        String secret = scan.nextLine();

        //get key (seed)
        long key = scan.nextLong();

        Random rand = new Random(key);

        for (int i = 0; i < secret.length(); i++) {
            char ch = (char) (secret.charAt(i) + rand.nextInt(128));
            if (ch >= 128) {
                ch -= 128;
            }
            System.out.print(ch);
        }
        System.out.println();
    }
}