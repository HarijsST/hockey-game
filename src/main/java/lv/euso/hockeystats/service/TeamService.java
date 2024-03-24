package lv.euso.hockeystats.service;

import lv.euso.hockeystats.model.Team;

import java.util.List;

public interface TeamService{
    Team createTeam(Team team);
    List<Team> findAllTeams();
    Team findTeamByID(Long id);
    Team updateTeamInfo(Team team, Long id);
    void deleteTeam(Long id);
}
