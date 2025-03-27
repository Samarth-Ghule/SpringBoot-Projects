package com.ipl.Team_Select.controller;




import java.util.Arrays;
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

import com.ipl.Team_Select.entity.Player;
import com.ipl.Team_Select.service.PlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("player")
@Validated
public class PlayerController {
	
	@Autowired
	PlayerService service;
	
	@PostMapping("addPlayer")
	public ResponseEntity<String> insertPlayer(@Valid @RequestBody Player p)
	{
		String msg = service.insertPlayer(p);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updatePlayer/{id}")
	public ResponseEntity<String> updatePlayer(@Valid @PathVariable long id, @RequestBody Player p){
		String msg = service.updatePlayer(id,p);
		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id must be greater than zero!");
		}
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deletePlayer/{id}")
	public ResponseEntity<String> deletePlayer(@PathVariable long id){
		String msg = service.deletePlayer(id);
		if (id <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id must be greater than zero!");
		}
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<List<Player>> getAllPlayer(){
		List<Player> plist = service.getAllPlayer();
		return ResponseEntity.ok(plist);
	}
	
	@GetMapping("getById/{id}")
	public ResponseEntity<Object> getPlayerById(@PathVariable long id){
		Player p = service.getPlayerById(id);
		if (Objects.isNull(p)) {
			return new ResponseEntity<>("Player Not Found With Id : "+id, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(p);
	}
	
	
	@GetMapping("getPlayerByRole/{role}")
	public ResponseEntity<?> getPlayersByRole(@PathVariable String role) {
	   
	    List<String> validRoles = Arrays.asList("Batsman", "Bowler", "All-rounder", "Wicket-keeper");
	    if (!validRoles.contains(role)) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                             .body("Invalid role! Role must be Batsman, Bowler, All-rounder, or Wicket-keeper.");
	    }
	    
	    List<Player> roleList = service.getPlayerByRole(role);
	    
	    if (roleList == null || roleList.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("No Players found for role: " + role);
	    }

	    return ResponseEntity.ok(roleList);
	}
	
	@GetMapping("getTopScoredPlayers/{runsScored}")
	public ResponseEntity<?> getTopScoredPlayers(@PathVariable Integer runsScored){
		 List<Player> topScoredPlayerslist = service.getTopScoredPlayers(runsScored);
		 if (runsScored <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("runs must be greater than zero!");
		}
		 return ResponseEntity.ok(topScoredPlayerslist);
	}
	
	@GetMapping("getTopWicketsTakenPlayers/{wicketsTaken}")
	public ResponseEntity<?> getTopWicketsTakenPlayers(@PathVariable Integer wicketsTaken){
		List<Player> topWicketsTakenPlayersList = service.getTopWicketsTakenPlayers(wicketsTaken);
		 if (wicketsTaken <= 0) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wickets must be greater than zero!");
			}
		return ResponseEntity.ok(topWicketsTakenPlayersList);
	}
	
	@GetMapping("getPlayerByTeamId/{tid}")
	public ResponseEntity<?> getPlayerByTeamId(@PathVariable long tid){
		List<Player> getPlayerByTeamIdList = service.getPlayerByTeamId(tid);
		if (tid <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("team id must be greater than zero!");
		}
		
		if (getPlayerByTeamIdList == null || getPlayerByTeamIdList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team Not found with id : "+ tid);
		}
		return ResponseEntity.ok(getPlayerByTeamIdList);
	}

}
