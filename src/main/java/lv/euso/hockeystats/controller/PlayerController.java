package lv.euso.hockeystats.controller;

import lv.euso.hockeystats.model.Player;
import lv.euso.hockeystats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/player")
@RestController
public class PlayerController {
    @Autowired
    private PlayerService service;
    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return service.createPlayer(player);
    }
    @GetMapping("/all_players")
    public List findAllPlayers(){
        return service.findAllPlayers();
    }
    @GetMapping("/{id}")
    public Player findPlayerByID(@PathVariable Long id){
        return service.findPlayerByID(id);
    }
    @PutMapping("/{id}")
    public Player updatePlayerInfo(@RequestBody Player player, @PathVariable Long id){
        return service.updatePlayerInfo(player, id);
    }
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id){
        service.deletePlayer(id);
    }
}
