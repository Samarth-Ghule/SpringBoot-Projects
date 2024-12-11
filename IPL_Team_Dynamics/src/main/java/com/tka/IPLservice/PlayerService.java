package com.tka.IPLservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.IPLdao.PlayerDao;
import com.tka.IPLentity.Player;

@Service
public class PlayerService {
	@Autowired
	PlayerDao playerdao;

	public List<Player> getPlayerList() {
		List<Player> plist = playerdao.getPlayerList();
		return plist;
	}

	public Player getOnePlayer() {
		Player op = playerdao.getOnePlayer();
		return op;
	}

	public void insertPlayer(Player p) {
		playerdao.insertPlayer(p);
	}

	public void updatePlayer(Player p) {
		playerdao.updatePlayer(p);
	}

	public void deletePlayer(int jn) {
		playerdao.deletePlayer(jn);
	}

	public List<Player> getmiPlayerList() {
		List<Player> milist = playerdao.getmiPlayerList();
		return milist;
	}

	public List<Player> getcskPlayerList() {
		List<Player> csklist = playerdao.getcskPlayerList();
		return csklist;
	}

	public List<Player> getrcbPlayerList() {
		List<Player> rcblist = playerdao.getrcbPlayerList();
		return rcblist;
	}

	public List<Player> getbatterList() {
		List<Player> blist = playerdao.getbatterList();
		return blist;
	}

	public List<Player> getbowlerList() {
		List<Player> blist = playerdao.getbowlerList();
		return blist;
	}

}
