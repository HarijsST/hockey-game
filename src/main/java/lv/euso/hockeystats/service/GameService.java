package lv.euso.hockeystats.service;

import lv.euso.hockeystats.model.Game;
import lv.euso.hockeystats.model.Team;
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
        Team homeTeam = teamService.findTeamByID(homeTeamID);
        Team awayTeam = teamService.findTeamByID(awayTeamID);
        String homeTeamName = homeTeam.getName();
        String awayTeamName = awayTeam.getName();
        int homeScoreFromOverall = homeTeam.getOverall() / 100;
        int awayScoreFromOverall = awayTeam.getOverall() / 100;
        game.setHomeTeamID(homeTeamID);
        game.setHomeScore(homeScoreFromOverall);
        game.setAwayScore(awayScoreFromOverall);
        game.setAwayTeamID(awayTeamID);
        gameRepository.save(game);
        return homeTeamName + " " + homeScoreFromOverall + " : " + awayScoreFromOverall + " " + awayTeamName;
    }
}
