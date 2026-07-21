package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round (String playerName1, String playerName2) {
        int p1 = findByName(playerName1).getStrength();
        int p2 = findByName(playerName2).getStrength();
        if (p1 > p2) {
            return 1;
        } else if (p2 > p1) {
            return 2;
        }
        return 0;
    }

    public Player findByName(String plName) {
        for (Player player: players){
            if (Objects.equals(player.getName(), plName)) {
                return player;
            }
        }
        throw new NotRegisteredException("Element with name: " + plName + " not found");
    }
}
