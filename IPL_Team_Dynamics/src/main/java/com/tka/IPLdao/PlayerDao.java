package com.tka.IPLdao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.IPLentity.Player;

@Repository
public class PlayerDao {

	@Autowired
	SessionFactory sessionfactory;

	public List<Player> getPlayerList() {
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		List<Player> plist = criteria.list();
		return plist;
	}

	public Player getOnePlayer() {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Player player = session.load(Player.class, 45);
		return player;
	}

	public void insertPlayer(Player p) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}

	public void updatePlayer(Player p) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
	}

	public void deletePlayer(int jn) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Player pl = session.load(Player.class, jn);
		session.delete(pl);
		session.getTransaction().commit();
	}

	public List<Player> getmiPlayerList() {
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		List<Player> plist = criteria.list();
		List<Player> milist = new ArrayList<Player>();
		for (Player player : plist) {
			if (player.getTname().equals("MI")) {
				milist.add(player);
			}
		}
		return milist;
	}

	public List<Player> getcskPlayerList() {
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		List<Player> plist = criteria.list();
		List<Player> csklist = new ArrayList<Player>();
		for (Player player : plist) {
			if (player.getTname().equals("CSK")) {
				csklist.add(player);
			}
		}
		return csklist;
	}

	public List<Player> getrcbPlayerList() {
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		List<Player> plist = criteria.list();
		List<Player> rcblist = new ArrayList<Player>();
		for (Player player : plist) {
			if (player.getTname().equals("RCB")) {
				rcblist.add(player);
			}
		}
		return rcblist;
	}

	public List<Player> getbatterList() {
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		List<Player> plist = criteria.list();
		List<Player> batlist = new ArrayList<Player>();
		for (Player player : plist) {
			if (player.getRuns() > 3000) {
				batlist.add(player);
			}
		}
		return batlist;
	}

	public List<Player> getbowlerList() {
		Session session = sessionfactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		List<Player> plist = criteria.list();
		List<Player> bowllist = new ArrayList<Player>();
		for (Player player : plist) {
			if (player.getWicket() > 80) {
				bowllist.add(player);
			}
		}
		return bowllist;
	}

}
