package lv.euso.hockeystats.service;

import lv.euso.hockeystats.model.Player;

import java.util.List;

public interface PlayerService {
    Player createPlayer(Player player);
    List<Player> findAllPlayers();
    Player findPlayerByID(Long id);
    Player updatePlayerInfo(Player player, Long id);
    void deletePlayer(Long id);
}
