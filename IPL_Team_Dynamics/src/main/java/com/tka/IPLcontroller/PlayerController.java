package com.tka.IPLcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.IPLentity.Player;
import com.tka.IPLservice.PlayerService;

@RestController
public class PlayerController {
	@Autowired
	PlayerService playerservice;

	@GetMapping("/allplayer")
	public List<Player> getPlayerList() {
		List<Player> plist = playerservice.getPlayerList();
		return plist;
	}

	@GetMapping("oneplayer")
	public Player getOnePlayer() {
		Player op = playerservice.getOnePlayer();
		return op;
	}

	@PostMapping("insertplayer")
	public void insertPlayer(@RequestBody Player p) {
		playerservice.insertPlayer(p);
	}

	@PutMapping("updateplayer")
	public void updatePlayer(@RequestBody Player p) {
		playerservice.updatePlayer(p);
	}

	@DeleteMapping("deleteplayer")
	public void deletePlayer(@RequestParam int jn) {
		playerservice.deletePlayer(jn);
	}

	@GetMapping("/miplayer")
	public List<Player> getmiPlayerList() {
		List<Player> milist = playerservice.getmiPlayerList();
		return milist;
	}

	@GetMapping("/cskplayer")
	public List<Player> getcskPlayerList() {
		List<Player> csklist = playerservice.getcskPlayerList();
		return csklist;
	}

	@GetMapping("/rcbplayer")
	public List<Player> getrcbPlayerList() {
		List<Player> rcblist = playerservice.getrcbPlayerList();
		return rcblist;
	}
	
	@GetMapping("/batterlist")
	public List<Player> getbatterList(){
		List<Player> blist = playerservice.getbatterList();
		return blist;
	}
	
	@GetMapping("/bowlerlist")
	public List<Player> getbowlerList(){
		List<Player> blist = playerservice.getbowlerList();
		return blist;
	}

}
