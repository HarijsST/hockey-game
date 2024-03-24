package lv.euso.hockeystats.service;

import lv.euso.hockeystats.model.Game;
import lv.euso.hockeystats.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService{
    @Autowired
    TeamService teamService;
    @Autowired
    GameRepository gameRepository;

    public String getResult(Long homeTeamID, Long awayTeamID){
        Game game = new Game();
        String homeTeamName = teamService.findTeamByID(homeTeamID).getName();
        String awayTeamName = teamService.findTeamByID(awayTeamID).getName();
        Random rand = new Random();
        int homeScore = rand.nextInt(10);
        int awayScore = rand.nextInt(10);
        game.setHomeTeamID(homeTeamID);
        game.setHomeScore(homeScore);
        game.setAwayScore(awayScore);
        game.setAwayTeamID(awayTeamID);
        gameRepository.save(game);
        return homeTeamName + " " + homeScore + " : " + awayScore + " " + awayTeamName;
    }
}
