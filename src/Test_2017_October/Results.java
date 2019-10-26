package Test_2017_October;

import java.util.ArrayList;

public class Results {

    private ArrayList<Team> teams;

    /**
     * Skapar ett objekt som håller reda på lag och deras resultat i en tävling.
     * Vektorn names innehåller namnen på deltagande lag.
     */
    Results(String[] names){
        teams = new ArrayList<>();
        for (int i = 0; i < names.length ; i++) {
            teams.add(new Team(names[i]));
        }
    }

    /**
     * Lägger till ytterligare ett lag. Laget har namnet name.
     */
    void add(String name){
        teams.add(new Team(name));
    }

    /**
     * Registrerar att laget med namn name har gjort ett försök på uppgift nbr
     * vid tidpunkten time. Om försöket är godkänt har approved värdet true.
     * Om det inte finns något lag med namnet name händer ingenting.
     * nbr antas ligga inom det tillåtna intervallet.
     */
    void registerResult(String name, int nbr, int time, boolean approved){
        for(Team team: teams){
            if(team.getName().equals(name)){
                team.registerAttempt(nbr,time,approved);
                return;
            }
        }

    }

    /**
     * Skriver ut alla lagens resultat (ej sorterat).
     */
    void printResult(){
        for(Team team: teams){
            System.out.println(team);
        }
    }

    public int[] nbrSolved() {
        int[] solved = new int[Contest.NBR_PROBLEMS];
        for(int i = 0; i < Contest.NBR_PROBLEMS; i++) {
            for (Team t : teams) {
                if (t.solved(i)) {
                    solved[i] ++;
                }
            }
        }
        return solved;
    }
}
