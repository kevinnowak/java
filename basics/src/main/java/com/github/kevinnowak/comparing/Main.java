package com.github.kevinnowak.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Main {

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        // Sorting by ranking without a Comparator -> uses Player's compareTo()
        Collections.sort(footballTeam);

        // Sorting by ranking providing an implementation of a Comparator class
        Collections.sort(footballTeam, new PlayerRankingComparator());
        Collections.sort(footballTeam, Comparator.comparingInt(Player::getRanking)); // Does the same

        // Sorting by age providing an implementation of a Comparator class
        Collections.sort(footballTeam, new PlayerAgeComparator());
        Collections.sort(footballTeam, Comparator.comparingInt(Player::getAge)); // Does the same
        Collections.sort(footballTeam, (Player p1, Player p2) -> Integer.compare(p1.getAge(), p2.getAge())); // Does the same
    }
}
