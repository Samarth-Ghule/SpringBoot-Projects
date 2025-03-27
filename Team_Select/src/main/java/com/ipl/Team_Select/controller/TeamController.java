package com.ipl.Team_Select.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipl.Team_Select.entity.Team;
import com.ipl.Team_Select.service.TeamService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("team")
@Validated
public class TeamController {
	
	@Autowired
	TeamService service;
	
	@PostMapping("addTeam")
	public ResponseEntity<String> addTeam(@Valid @RequestBody Team team){
		String msg = service.addTeam(team);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updateTeam/{tid}")
	public ResponseEntity<String> updateTeam(@Valid @PathVariable long tid, @RequestBody Team team){
		String msg = service.updateTeam(tid,team);
		if (tid <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("team id must be greater than zero!");
		}
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleteTeam/{tid}")
	public ResponseEntity<String> deleteTeam(@PathVariable long tid){
		String msg = service.deleteTeam(tid);
		if (tid <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("team id must be greater than zero!");
		}
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Team>> getAllTeam(){
		List<Team> teamList = service.getAllTeam();
		return ResponseEntity.ok(teamList);
	}
	
	@GetMapping("getById/{tid}")
	public ResponseEntity<?> getTeamById(@PathVariable long tid){
		Team team = service.getTeamById(tid);
		if (tid <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("team id must be greater than zero!");
		}
		
		if (Objects.isNull(team)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team Not Found With Id : "+tid);
		}
		return ResponseEntity.ok(team);
	}
}
