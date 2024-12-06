package com.tka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Country;
import com.tka.entity.Employee;
import com.tka.service.EmployeeService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country c) {
		String msg = service.addCountry(c);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateCountry/{id}")
	public ResponseEntity<String> updateCountry(@RequestBody Country c, @PathVariable int id) {
		String msg = service.updateCountry(c, id);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deleteCountry/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable int id) {
		String msg = service.deleteCountry(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getAllCountry")
	public ResponseEntity<List<Country>> getAllCountry() {

		List<Country> list = service.getAllCountry();
		return ResponseEntity.ok(list);

	}

	@GetMapping("getCountryById/{id}")
	public ResponseEntity<Country> getParticularCountryById(@PathVariable int id) {
		Country con = service.getParticularCountryById(id);
		return ResponseEntity.status(201).body(con);
	}

	@PostMapping("addEmployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {

		String msg = service.addEmployee(emp);
		return ResponseEntity.ok(msg);
	}

	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Employee emp) {
		Map map = service.login(emp);
		return ResponseEntity.ok(map);
	}

	@GetMapping("salaryRange/{startSal}/{endSal}")
	public ResponseEntity<List<Employee>> salaryRange(@PathVariable double startSal, @PathVariable double endSal) {
		List<Employee> list = service.salaryRange(startSal, endSal);
		return ResponseEntity.ok(list);
	}

	@PutMapping("updateEmployee/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee e, @PathVariable long id) {
		String msg = service.updateEmployee(e, id);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
		String msg = service.deleteEmployee(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = service.getAllEmployee();
		return ResponseEntity.ok(list);
	}

	@GetMapping("getEmployeeById/{id}")
	public Employee getParticularEmployeeById(@PathVariable long id) {
		Employee emp = service.getParticularEmployeeById(id);
		return emp;
	}
}
