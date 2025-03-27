package com.ipl.Team_Select.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipl.Team_Select.entity.Team;

@Repository
public class TeamDao {
	
	@Autowired
	SessionFactory factory;

	public String addTeam(Team team) {
		String msg ;
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				session.persist(team);
				tx.commit();
				msg = "Team Added Successfully...";
				
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Failed to add Team: " + e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	
	public String updateTeam(long tid, Team team) {
		String msg;
		Team t = null;
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				t = session.get(Team.class, tid);
				if (t != null) {
					t.setCaptain(team.getCaptain());
					t.setChampionshipsWon(team.getChampionshipsWon());
					session.merge(t);
					tx.commit();
					msg = "Team Updated Successfully...";
				}else {
					msg = "Team Not Found!";
				}
				
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Failed to Update Team: "+ e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}
	
	
	public String deleteTeam(long tid) {
		String msg;
		Team team = null;
		try(Session session = factory.openSession()){
			Transaction tx = session.beginTransaction();
			try {
				team = session.get(Team.class, tid);
				if (team != null) {
					session.remove(team);
					tx.commit();
					msg = "Team Deleted Successfully...";
				}else {
					msg = "Team Not Found!";
				}
				
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Failed to Delete Team: "+ e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}


	public List<Team> getAllTeam() {
		String hql = "from Team";
		List<Team> teamList = null;
		try(Session session = factory.openSession()){
			Query<Team> query = session.createQuery(hql, Team.class);
			teamList = query.list();
		}
		return teamList;
	}


	public Team getTeamById(long tid) {
		Team team = null;
		try(Session session = factory.openSession()){
			team = session.get(Team.class, tid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return team;
	}
	
	
	

}
