package lv.euso.hockeystats.service;

import lv.euso.hockeystats.model.Player;
import lv.euso.hockeystats.model.Team;
import lv.euso.hockeystats.repository.PlayerRepository;
import lv.euso.hockeystats.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class DefaultPlayerService implements PlayerService {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TeamService teamService;
    @Override
    public Player createPlayer(Player player){
        Random random = new Random();
        player.setOverall(random.nextInt(50, 101));
        if(player.getTeam() != null){
            Long teamID = player.getTeam().getTeamID();
            Optional<Team> teamFromDB = teamRepository.findById(teamID);
            if(teamFromDB.isPresent()){
                Team team = teamFromDB.get();
                player.setTeam(team);
            } else {
                player.getTeam().setTeamID(null);
                player.getTeam().setName("No team");
            }
        }
        Player savedPlayer = playerRepository.save(player);
        teamService.updateTeamOverall(player.getTeam().getTeamID());
        return savedPlayer;
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player findPlayerByID(Long id){
       return playerRepository.findById(id).orElseThrow(()-> new RuntimeException("Player not found"));
    }

    @Override
    public Player updatePlayerInfo(Player player,Long id){
        Player updatedPlayer = findPlayerByID(id);
        updatedPlayer.setName(player.getName());
        updatedPlayer.setLastName(player.getLastName());
        playerRepository.save(updatedPlayer);
        return updatedPlayer;
    }

    @Override
    public void deletePlayer(Long id){
        Player player = findPlayerByID(id);
        player.setTeam(null);
        playerRepository.deleteById(id);
    }
}
