package lv.euso.hockeystats.controller;

import lv.euso.hockeystats.model.Team;
import lv.euso.hockeystats.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/team")
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    @PostMapping
    public Team createTeam(@RequestBody Team team){
        return teamService.createTeam(team);
    }
    @GetMapping("/all_teams")
    public List<Team> findAllTeams(){
        return teamService.findAllTeams();
    }
    @GetMapping("/{id}")
    public Team findTeamByID(@PathVariable Long id){
        return teamService.findTeamByID(id);
    }
    @PutMapping("/{id}")
    public Team updateTeamInfo(@RequestBody Team team, @PathVariable Long id){
        return teamService.updateTeamInfo(team, id);
    }
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
    }
}
