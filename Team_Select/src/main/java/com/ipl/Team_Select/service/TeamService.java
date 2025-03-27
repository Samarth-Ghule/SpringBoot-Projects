package com.ipl.Team_Select.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.Team_Select.dao.TeamDao;
import com.ipl.Team_Select.entity.Team;

import jakarta.validation.Valid;

@Service
public class TeamService {
	
	@Autowired
	TeamDao dao;

	public String addTeam(Team team) {
		String msg = dao.addTeam(team);
		return msg;
	}
	
	public String updateTeam(long tid, Team team) {
		String msg = dao.updateTeam(tid,team);
		return msg;
	}

	public String deleteTeam(long tid) {
		String msg = dao.deleteTeam(tid);
		return msg;
	}

	public List<Team> getAllTeam() {
		List<Team> teamList = dao.getAllTeam();
		return teamList;
	}

	public Team getTeamById(long tid) {
		Team team = dao.getTeamById(tid);
		return team;
	}

	

}
