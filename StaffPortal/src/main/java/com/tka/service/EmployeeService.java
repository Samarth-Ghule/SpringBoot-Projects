package com.tka.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.EmployeeDao;
import com.tka.entity.Country;
import com.tka.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao dao;

	public String addCountry(Country c) {
		String msg = dao.addCountry(c);
		if (Objects.isNull(msg)) {
			msg = "Country is Not addedd";
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {
		String msg = dao.updateCountry(c, id);
		if (Objects.isNull(msg)) {
			msg = "Country is not Updated";
		}
		return msg;
	}

	public String deleteCountry(int id) {

		String msg = dao.deleteCountry(id);
		if (Objects.isNull(msg)) {
			msg = "Country is not Deleted";
		}
		return msg;
	}

	public List<Country> getAllCountry() {
		List<Country> list = dao.getAllCountry();
		return list;
	}

	public Country getParticularCountryById(int id) {
		Country con = dao.getParticularCountryById(id);
		return con;
	}

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		if (Objects.isNull(msg)) {
			msg = "Employee Addedd Successfully";
		}
		return msg;
	}

	public Map login(Employee emp) {
		Employee obj = dao.login(emp);
		Map map = new HashMap();
		if (Objects.isNull(obj)) {
			map.put("msg", "Invalid User");
			map.put("user", obj);
		} else {
			map.put("msg", "Valid User");
			map.put("user", obj);
		}
		return map;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
		List<Employee> list = dao.salaryRange(startSal, endSal);
		return list;
	}

	public String updateEmployee(Employee e, long id) {
		String msg = dao.updateEmployee(e, id);
		if (Objects.isNull(msg)) {
			msg = "Employee is not Updated";
		}
		return msg;

	}

	public String deleteEmployee(long id) {
		String msg = dao.deleteEmployee(id);
		if (Objects.isNull(msg)) {
			msg = "Employee is not Deleted";
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list = dao.getAllEmployee();
		return list;
	}

	public Employee getParticularEmployeeById(long id) {
		Employee emp = dao.getParticularEmployeeById(id);
		return emp;
	}
}
