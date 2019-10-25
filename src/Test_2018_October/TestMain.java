package Test_2018_October;

import java.util.ArrayList;
import java.util.Scanner;


public class TestMain {

    public static void main(String[] args) {
        ArrayList<Applicant> applicants = null;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number to be selected:");
        int n = scan.nextInt();
        System.out.println("Write the ID numbers for them" + n +
                "first persons on the ranking list:");
        ArrayList<Integer> reviewList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            reviewList.add(scan.nextInt());
        }

        ApplicantSelector selector = new ApplicantSelector(applicants);
        ArrayList<Integer> testList = selector.getBestMean(n);
        System.out.println("Utvalda av testet: " + testList);
        System.out.println("Både med i chefens rankinglista och utvalda av testet: " +
                Intersection.interSection(reviewList, testList));
        System.out.println("Jaccardindex: " +
                Intersection.jaccardIndex(reviewList, testList));
    }
}
