package com.tka.IPLentity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Component
@Entity
@Table(name = "player", schema = "ipl")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Player {
	@Id
	private int jn;
	private String name;
	private int runs;
	private int wicket;
	private String tname;

	public Player() {
		super();
	}

	public Player(int jn, String name, int runs, int wicket, String tname) {
		super();
		this.jn = jn;
		this.name = name;
		this.runs = runs;
		this.wicket = wicket;
		this.tname = tname;
	}

	public int getJn() {
		return jn;
	}

	public void setJn(int jn) {
		this.jn = jn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWicket() {
		return wicket;
	}

	public void setWicket(int wicket) {
		this.wicket = wicket;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "Player [jn=" + jn + ", name=" + name + ", runs=" + runs + ", wicket=" + wicket + ", tname=" + tname
				+ "]";
	}

}
