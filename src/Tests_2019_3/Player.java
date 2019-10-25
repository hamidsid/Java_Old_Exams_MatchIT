package Tests_2019_3;

import java.util.ArrayList;

public class Player {

    private int id;
    private double score;
    private int nbrGames;
    private ArrayList<Player> players;


    /**
     * Skapar en ny tävlande med nummer id, som inledningsvis har 0 poäng,
     * inga spelade matcher och inga tilldelade motståndare
     */
    public Player(int id) {
        this.id = id;
        score = 0.0;
        nbrGames = 0;
        players = new ArrayList<>();
    }

    /**
     * Returnerar den tävlandes nummer
     */
    public int getId() {
        return id;
    }

    /**
     * Returnerar den tävlandes poäng
     */
    public double getScore() {
        return score;
    }

    /**
     * Returnerar antalet matcher den tävlande spelat
     */
    public int getNbrGames() {

        //nbr games playes is the same with the number players played
        return nbrGames;
    }

    /**
     * Returnerar antalet motståndare som tilldelats den tävlande
     */
    public int getNbrOpponents() {
        return players.size();
    }

    /**
     * Returnerar den tävlandes i:te motståndare (1,2,3,...)
     * Returnerar null om det inte finns någon i:te motståndare
     */
     public Player getOpponent(int i) {
        if (i > 0 && i <= players.size()) {
            return players.get(i - 1);
        } else {
            return null;
        }
    }

    /**
     * Returnerar true om p finns med bland den tävlandes motståndare,
     * annars false
     */
    public boolean isOpponent(Player p) {
        for (Player player : players) {
            if (player.getId() == p.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Noterar opp som den tävlandes nästa motståndare
     */
    public void addNextOpponent(Player opp) {
        players.add(opp);
    }

    /**
     * Noterar att den tävlande spelat en match till och där fick poängen point
     */
    public void addResult(double point) {
        nbrGames++;
        score += point;
    }

    /**
     * Returnerar den tävlandes resultat på formen:
     * id: <antal spelade> <antal poäng>
     */
    public String toString() {
        return id + ": " + nbrGames + " " + score;
    }
}
