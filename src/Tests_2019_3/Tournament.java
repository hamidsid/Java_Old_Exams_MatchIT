package Tests_2019_3;

import java.util.ArrayList;

public class Tournament {
    private ArrayList<Player> allPlayers;

    /**
     * Skapar en ny turnering för de tävlande i players
     */
    public Tournament(ArrayList<Player> players) {
        allPlayers = players;
    }

    /**
     * Returnerar en sorterad aktuell resultatlista
     */
    private ArrayList<Player> newPlayerRank() {

        //returns a list of descending ordered list of players
        ArrayList<Player> rankSort = new ArrayList<>();

        for (Player player : allPlayers) {

            //index to trace max score player
            int pos = rankSort.size() - 1;
            while (pos >= 0 && player.getScore() > rankSort.get(pos).getScore()) {
                pos--;
            }
            rankSort.add(pos + 1, player);
        }
        return rankSort;
    }

    /**
     * Skriver ut en sorterad aktuell resultatlista, med en tävlande per
     * rad på formen: id: <antal spelade> <antal poäng>
     */
    public void printPlayerRank() {
        ArrayList<Player> rankedPlayers = newPlayerRank();
        for (Player player : rankedPlayers) {
            player.toString();
        }
    }

    /**
     * Noterar vilka tävlande som ska mötas i nästa runda, samt returnerar en
     * lista med de tävlande som inte kunde tilldelas en ny motståndare
     */
    public ArrayList<Player> setNextRoundOpponents() {
        ArrayList<Player> unpairedPlayers = new ArrayList<>();
        ArrayList<Player> playerRank = newPlayerRank();
        while (!playerRank.isEmpty()) {

            //remove best player from list
            Player best = playerRank.remove(0);

            for (int i = 0; i < playerRank.size(); i++) {
                if (!best.isOpponent(playerRank.get(i))) {

                    //if not paired before, pair them
                    best.addNextOpponent(playerRank.get(i));
                    playerRank.get(i).addNextOpponent(best);

                } else {
                    unpairedPlayers.add(best);
                }
            }
        }

        return unpairedPlayers;
    }

    /**
     * Noterar att den tävlande med nummer id spelat en match till och fick där
     * poängen point
     */
    public void addNewResult(int id, double point) {
        for (Player player : allPlayers) {
            if (player.getId() == id) {
                player.addResult(point);
            }
        }
    }


    public String remainingGames() {
        StringBuilder sb = new StringBuilder();
        for (Player player : allPlayers) {
            if (player.getNbrOpponents() > player.getNbrGames()) { //has not played last match

                //get the last player in the list
                Player opp = player.getOpponent(player.getNbrOpponents());
                if (player.getId() < opp.getId()) {

                    sb.append(player.getId() + " - " + opp.getId());
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }
}
