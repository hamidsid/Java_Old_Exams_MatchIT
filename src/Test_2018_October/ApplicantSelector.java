package Test_2018_October;

import java.util.ArrayList;

public class ApplicantSelector {

    private ArrayList<Applicant> applicants;

    /**
     * Skapar ett objekt som kan välja ut sökande bland de i listan applicants.
     */
    ApplicantSelector(ArrayList<Applicant> applicants) {
        this.applicants = applicants;
    }

    /**
     * Returnerar en lista med idnummer för de nbr sökande som har högst
     * medelvärde på sina testresultat. Om nbr är större än antal sökande ska den
     * lista som returneras innehålla alla sökandes idnummer.
     */
    ArrayList<Integer> getBestMean(int nbr) {
        ArrayList<Applicant> list = new ArrayList<Applicant>();
        for (int i= 0; i < applicants.size(); i++) {
            list.add(applicants.get(i));
        }
        if (nbr > list.size()) {
            nbr = list.size();
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < nbr; i++) {
            int maxPos = getBestMeanIndex(list);
            temp.add(list.get(maxPos).getId());
            list.remove(maxPos);
        }
        return temp;
    }

    private int getBestMeanIndex(ArrayList<Applicant> list) {
        double max = - Double.MAX_VALUE;
        int maxPos = -1;
        for (int i = 0; i < list.size(); i++) {
            double mean = list.get(i).mean();
            if (mean > max ) {
                max = mean;
                maxPos = i;
            }
        }
        return maxPos;
    }
}
