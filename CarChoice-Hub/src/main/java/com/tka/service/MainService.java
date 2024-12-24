package com.tka.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.MainDao;
import com.tka.entity.Car;
import com.tka.entity.Customer;

@Service
public class MainService {

	@Autowired
	MainDao dao;

	public String addCar(Car c) {

		String msg = dao.addCar(c);
		if (Objects.isNull(msg)) {
			msg = "Data is Not Added...";
		}
		return msg;
	}

	public String updateCar(Car c, int id) {

		String msg = dao.updateCar(c, id);
		if (Objects.isNull(msg)) {
			msg = "Car Not Updated...";
		}
		return msg;
	}

	public String deleteCar(int id) {

		String msg = dao.deleteCar(id);

		if (Objects.isNull(msg)) {
			msg = "Car is Not Deleted...";
		}
		return msg;
	}

	public List<Car> getAllCar() {
		List<Car> clist = dao.getAllCar();
		return clist;
	}

	public Car getParticularCarById(int id) {
		Car c = dao.getParticularCarById(id);
		return c;
	}

	public String addCustomer(Customer cm) {
		String msg = dao.addCustomer(cm);
		if (Objects.isNull(msg)) {
			msg = "Customer is Not Added...";
		}
		return msg;
	}

	public Map login(Customer c) {

		Customer customer = dao.login(c);
		Map map = new HashMap();
		if (Objects.isNull(customer)) {
			map.put("msg", "Invalid User");
			map.put("User", customer);
		} else {
			map.put("msg", "Valid User");
			map.put("User", customer);
		}

		return map;
	}

	public String updateCustomer(Customer c, int id) {
		
		String msg = dao.updateCustomer(c,id);
		if (Objects.isNull(msg)) {
			msg = "Cutomer is not Updated...";
		}
		return msg;
	}

	public String deleteCustomer(int id) {
		String msg = dao.deleteCustomer(id);
		if (Objects.isNull(msg)) {
			msg = "Customer is not Deleted...";
		}
		return msg;
	}

	public List<Customer> getAllCustomer() {
		List<Customer> clist = dao.getAllCustomer();
		return clist;
	}

	public Customer getCustomerById(int id) {
		Customer customer = dao.getCustomerById(id);
		return customer;
	}


}
