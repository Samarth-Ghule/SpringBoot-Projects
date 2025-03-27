package com.ipl.Team_Select.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipl.Team_Select.entity.Player;

import jakarta.validation.Valid;

@Repository
public class PlayerDao {

	@Autowired
	SessionFactory factory;

	public String insertPlayer(Player p) {
		String msg;

		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				session.persist(p);
				tx.commit();
				msg = "Player Added Successfully!";
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Failed to add player: " + e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String updatePlayer(long id, Player p) {
		String msg;
		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				Player player = session.get(Player.class, id);
				if (player != null) {
					player.setJerseyNumber(p.getJerseyNumber());
					player.setRole(p.getRole());
					player.setTeam(p.getTeam());
					player.setMatchesPlayed(p.getMatchesPlayed());
					player.setRunsScored(p.getRunsScored());
					player.setWicketsTaken(p.getWicketsTaken());
					session.merge(player);
					tx.commit();
					msg = "Player Updated...";
				} else {
					msg = "Player Not Found!";
				}
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Player Not Updated... " + e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public String deletePlayer(long id) {
		String msg;
		try (Session session = factory.openSession()) {
			Transaction tx = session.beginTransaction();
			try {
				Player p = session.get(Player.class, id);
				if (p != null) {
					session.remove(p);
					tx.commit();
					msg = "Player is Deleted...";
				}else {
					msg = "Player Not Found!";
				}
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				msg = "Player Not Deleted..." + e.getMessage();
				e.printStackTrace();
			}
		}
		return msg;
	}

	public List<Player> getAllPlayer() {
		String hql = "from Player";
		List<Player> plist;
		try (Session session = factory.openSession()) {
			Query<Player> query = session.createQuery(hql, Player.class);
			plist = query.list();
		}
		return plist;
	}	

	public Player getPlayerById(long id) {
		Player p = null;
		try(Session session = factory.openSession()){
			p = session.get(Player.class, id);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return p;
	}
	
	
}
