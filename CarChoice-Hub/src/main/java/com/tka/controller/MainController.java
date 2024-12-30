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

import com.tka.entity.Car;
import com.tka.entity.Customer;
import com.tka.service.MainService;

@RestController
@RequestMapping("api")
public class MainController {

	@Autowired
	MainService service;

	@PostMapping("addCar")
	public ResponseEntity<String> addCar(@RequestBody Car c) {

		String msg = service.addCar(c);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateCar/{id}")
	public ResponseEntity<String> updateCar(@RequestBody Car c, @PathVariable int id) {

		String msg = service.updateCar(c, id);
		return ResponseEntity.ok(msg);

	}

	@DeleteMapping("deleteCar/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable int id) {

		String msg = service.deleteCar(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getAllCar")
	public ResponseEntity<List<Car>> getAllCar() {
		List<Car> clist = service.getAllCar();
		return ResponseEntity.ok(clist);
	}

	@GetMapping("getCarById/{id}")
	public ResponseEntity<Car> getParticularCarById(@PathVariable int id) {
		Car c = service.getParticularCarById(id);
		/* return ResponseEntity.ok(c); */
		return ResponseEntity.status(201).body(c);

	}

	@PostMapping("addCustomer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer cm) {
		String msg = service.addCustomer(cm);
		return ResponseEntity.ok(msg);
	}

	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Customer c) {
		Map map = service.login(c);
		return ResponseEntity.ok(map);
	}

	@PutMapping("updateCustomer/{id}")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer c, @PathVariable int id) {
		String msg = service.updateCustomer(c, id);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id) {
		String msg = service.deleteCustomer(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> clist = service.getAllCustomer();
		return ResponseEntity.ok(clist);
	}

	@GetMapping("getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		Customer customer = service.getCustomerById(id);
		return ResponseEntity.ok(customer);

	}

	@GetMapping("status/{loanApprovalStatus}")
	public ResponseEntity<Map> getCustomerByLoanApprovalStatus(@PathVariable String loanApprovalStatus) {
		Map map = service.getCustomerByLoanApprovalStatus(loanApprovalStatus);
		return ResponseEntity.ok(map);
	}

	@GetMapping("price/{startPrice}/{lastPrice}")
	public ResponseEntity<Map> getCarByPriceRange(@PathVariable double startPrice, @PathVariable double lastPrice) {
		Map map = service.getCarByPriceRange(startPrice, lastPrice);
		return ResponseEntity.ok(map);
	}
}
