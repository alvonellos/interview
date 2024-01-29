package com.alvonellos.interview.Interviews.Walmart;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Log
public class TeamsService {
    private final TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        List<Team> teamList = new ArrayList<Team>();
        teamsRepository.findAll().forEach(team -> teamList.add(new Team(team)));
        return teamList;
    }

    public void getTeam(UUID teamId) {
        teamRepository.findById(teamId);
    }

    public void addTeam(Team team) {
        teamRepository.save(team);
        log.info("Added team: " + team);
    }

    public void removeTeam(Team team) {
        teamRepository.delete(team);
        log.info("Removed team: " + team);
    }

    public void updateTeam(Team team) {
        teamRepository.save(team);
        log.info("Updated team: " + team);
    }
}
