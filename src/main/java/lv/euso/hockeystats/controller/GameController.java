package lv.euso.hockeystats.controller;

import lv.euso.hockeystats.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GameController {
    @Autowired
    GameService gameService;
    @GetMapping("/result")
    public String getResult(@RequestParam Long homeTeamID, @RequestParam Long awayTeamID){
        return gameService.getResult(homeTeamID, awayTeamID);
    }
}
