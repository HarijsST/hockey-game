package lv.euso.hockeystats.service;

import lv.euso.hockeystats.model.Team;
import lv.euso.hockeystats.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultTeamService implements TeamService{
    @Autowired
    TeamRepository teamRepository;
    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public List<Team> findAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team findTeamByID(Long id) {
        return teamRepository.findById(id).orElseThrow(()-> new RuntimeException("Team not found"));
    }
    @Override
    public Team updateTeamInfo(Team team, Long id) {
        Team updatedTeam = findTeamByID(id);
        updatedTeam.setName(team.getName());
        teamRepository.save(updatedTeam);
        return updatedTeam;
    }
    @Override
    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
