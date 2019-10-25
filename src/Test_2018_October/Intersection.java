package Test_2018_October;

import java.util.ArrayList;

public class Intersection {

    /**
     * Returnerar en lista med snittet av set1 och set 2 (dvs. en lista med de
     * element som ingår i både set1 och set2).
     */
    static ArrayList<Integer> interSection(ArrayList<Integer> set1, ArrayList<Integer> set2) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer n1 : set1) {
            for (Integer n2 : set2) {
                if (n1 == n2) {
                    temp.add(n1);
                }
            }
        }
        return temp;
    }

    /**
     * Beräknar jaccardIndex för set1 och set2.
     */
    static double jaccardIndex(ArrayList<Integer> set1, ArrayList<Integer> set2) {

        int intersectionL = interSection(set1, set2).size();
        return (double) intersectionL / (set1.size() + set2.size() - intersectionL);
    }
}
