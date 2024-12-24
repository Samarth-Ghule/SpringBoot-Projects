package com.tka.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.PersonDao;
import com.tka.entity.Person;

@Service
public class PersonService {

	@Autowired
	PersonDao dao;

	public String addRecord(Person p) {

		String msg = dao.addRecord(p);
		if (Objects.isNull(msg)) {
			msg = "Person not Added...";
		}
		return msg;
	}

	public String updateRecord(Person p, int id) {

		String msg = dao.updateRecord(p, id);
		if (Objects.isNull(msg)) {
			msg = "Person not Updated..";
		}
		return msg;
	}

	public String deleteRecord(int id) {

		String msg = dao.deleteRecord(id);
		if (Objects.isNull(msg)) {
			msg = "Person not Deleted..";
		}
		return msg;
	}

	public List<Person> getAllRecord() {

		List<Person> list = dao.getAllRecord();
		return list;

	}

	public Person getPraticularRecordById(int id) {

		Person person = dao.getPraticularRecordById(id);
		return person;

	}

	public Person getPraticularRecordByCity(String city) {

		Person p = dao.getPraticularRecordByCity(city);
		return p;

	}

	public Map loginCheck(Person p) {

		
		Person person = dao.loginCheck(p);
		Map map = new HashMap();
		if (Objects.isNull(person)) {
			map.put("msg", "Invalid User...");
			map.put("User", person);
		}else {
			map.put("msg", "Valid User...");
			map.put("User", person);
		}
		return map;
	}
}
