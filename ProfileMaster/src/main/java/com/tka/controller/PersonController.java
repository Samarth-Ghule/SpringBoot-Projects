package com.tka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Person;
import com.tka.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {

	@Autowired
	PersonService service;

	@PostMapping("addRecord")
	public ResponseEntity<String> addRecord(@RequestBody Person p) {

		String msg = service.addRecord(p);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateRecord/{id}")
	public ResponseEntity<String> updateRecord(@RequestBody Person p, @PathVariable int id) {

		String msg = service.updateRecord(p, id);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deleteRecord/{id}")
	public ResponseEntity<String> deleteRecord(@PathVariable int id) {

		String msg = service.deleteRecord(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getAllRecord")
	public ResponseEntity<List<Person>> getAllRecord() {

		List<Person> list = service.getAllRecord();
		return ResponseEntity.ok(list);

	}

	@GetMapping("getRecordById/{id}")
	public ResponseEntity<Person> getPraticularRecordById(@PathVariable int id) {

		Person person = service.getPraticularRecordById(id);
		return ResponseEntity.ok(person);

	}

	@GetMapping("getRecordByCity")
	public ResponseEntity<Person> getPraticularRecordByCity(@RequestParam String city) {

		Person p = service.getPraticularRecordByCity(city);
		return ResponseEntity.ok(p);

	}

	@PostMapping("loginCheck")
	public ResponseEntity<Map> loginCheck(@RequestBody Person p) {

	    Map person = service.loginCheck(p);
		return ResponseEntity.ok(person);
	}
}
