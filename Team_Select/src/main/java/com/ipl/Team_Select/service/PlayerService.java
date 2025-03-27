package com.ipl.Team_Select.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.Team_Select.dao.PlayerDao;
import com.ipl.Team_Select.entity.Player;



@Service
public class PlayerService {
	
	@Autowired
	PlayerDao dao;

	public String insertPlayer(Player p) {
		String msg = dao.insertPlayer(p);
		return msg;
	}

	public String updatePlayer(long id, Player p) {
		String msg = dao.updatePlayer(id,p);
		return msg;
	}

	public String deletePlayer(long id) {
		String msg = dao.deletePlayer(id);
		return msg;
	}

	public List<Player> getAllPlayer() {
		List<Player> plist = dao.getAllPlayer();
		return plist;
	}

	public Player getPlayerById(long id) {
		Player p = dao.getPlayerById(id);
		return p;
	}


	public List<Player> getPlayerByRole(String role) {
		List<Player> plist = dao.getAllPlayer();
		List<Player> roleList = new ArrayList<Player>();
		for (Player p : plist) {
			if (p.getRole().equals(role)) {
				roleList.add(p);
			}
		}
		return roleList;
	}

	public List<Player> getTopScoredPlayers(Integer runsScored) {
		List<Player> plist = dao.getAllPlayer();
		List<Player> topScoredPlayerslist = new ArrayList<Player>();
		for (Player p : plist) {
			if (p.getRunsScored() > runsScored ) {
				topScoredPlayerslist.add(p);
			}
		}
		return topScoredPlayerslist;
	}

	public List<Player> getTopWicketsTakenPlayers(Integer wicketsTaken) {
		List<Player> plist = dao.getAllPlayer();
		List<Player> topWicketsTakenPlayersList = new ArrayList<Player>();
		
		for (Player p : plist) {
			if (p.getWicketsTaken() > wicketsTaken) {
				topWicketsTakenPlayersList.add(p);
			}
		}
		return topWicketsTakenPlayersList;
	}

	public List<Player> getPlayerByTeamId(long tid) {
		List<Player> plist = dao.getAllPlayer();
		List<Player> getPlayerByTeamIdList = new ArrayList<Player>();
		
		for (Player player : plist) {
			if (player.getTeam().getTid() == tid) {
				getPlayerByTeamIdList.add(player);
			}
		}
		return getPlayerByTeamIdList;
	}
	
	


}
