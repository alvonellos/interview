package com.alvonellos.interview.Interviews.Walmart;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api/v1/teams")
public class TeamsController {

    private final TeamsService teamsService;

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeamss() {
        return new ResponseEntity<>(teamsService.getAllTeams(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamsById(@PathVariable UUID teamId) {
        return new ResponseEntity<>(teamsService.getTeamById(teamId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Team> createTeams(@RequestBody Team team) {
        return new ResponseEntity<>(teamsService.createTeam(team), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeams(@PathVariable UUID teamId, @RequestBody Team team) {
        return new ResponseEntity<>(teamsService.updateTeam(teamId, team), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Teams> deleteTeams(@PathVariable UUID teamId) {
        return new ResponseEntity<>(teamsService.deleteTeam(teamId), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Teams> patchTeams(@PathVariable UUID teamId, @RequestBody TeamsPatchRequest TeamsPatchRequest) {
        return new ResponseEntity<>(teamsService.patchTeams(teamsId, TeamsPatchRequest), HttpStatus.OK);
    }
}