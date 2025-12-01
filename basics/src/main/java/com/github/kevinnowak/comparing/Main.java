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

//        System.out.println("Before sorting: " + footballTeam);
//        Collections.sort(footballTeam);
//        System.out.println("After sorting: " + footballTeam);

//        PlayerRankingComparator playerRankingComparator = new PlayerRankingComparator();
//        System.out.println("Before sorting: " + footballTeam);
//        Collections.sort(footballTeam, playerRankingComparator);
//        System.out.println("After sorting: " + footballTeam);

//        var playerAgeComparator = new PlayerAgeComparator();
//        System.out.println("Before sorting: " + footballTeam);
//        Collections.sort(footballTeam, playerAgeComparator);
//        System.out.println("After sorting: " + footballTeam);

//        Comparator<Player> byRanking = (Player p1, Player p2) -> Integer.compare(p1.getRanking(), p2.getRanking());
        Comparator<Player> byRanking = Comparator.comparingInt(Player::getRanking);
        Comparator<Player> byAge = Comparator.comparingInt(Player::getAge);
    }
}
