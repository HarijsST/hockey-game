package lv.euso.hockeystats.service;

import lv.euso.hockeystats.model.Game;
import lv.euso.hockeystats.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int homeScoreFromOverall = teamService.findTeamByID(homeTeamID).getOverall() / 100;
        int awayScoreFromOverall = teamService.findTeamByID(awayTeamID).getOverall() / 100;
        game.setHomeTeamID(homeTeamID);
        game.setHomeScore(homeScoreFromOverall);
        game.setAwayScore(awayScoreFromOverall);
        game.setAwayTeamID(awayTeamID);
        gameRepository.save(game);
        return homeTeamName + " " + homeScoreFromOverall + " : " + awayScoreFromOverall + " " + awayTeamName;
    }
}
