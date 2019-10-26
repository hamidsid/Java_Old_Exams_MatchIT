package Test_2017_October;

import java.util.Arrays;

public class Main_ {
    public static void main(String[] args) {
        String[] teamNames = {"Team1", "Team2", "Team3"};
        Results res = new Results(teamNames);
        res.add("Team4");
        res.registerResult("Team2", 2, 18, false);
        res.registerResult("Team3", 0, 19, false);
        res.registerResult("Team4", 2, 23, false);
        res.registerResult("Team2", 2, 28, true);
        res.registerResult("Team4", 2, 31, true);
        res.registerResult("Team1", 4, 31, false);
        res.registerResult("Team2", 4, 45, true);
        res.registerResult("Team3", 0, 60, true);
        res.registerResult("Team1", 2, 62, true);
        res.registerResult("Team2", 3, 62, true);
        res.registerResult("Team4", 3, 78, true);
        res.registerResult("Team2", 0, 101, true);
        res.printResult();
        System.out.println();
        System.out.println(Arrays.toString(res.nbrSolved()));
    }
}

