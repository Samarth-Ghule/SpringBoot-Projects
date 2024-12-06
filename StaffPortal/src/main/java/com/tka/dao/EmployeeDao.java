package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Country;
import com.tka.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Country Addedd Successfully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateCountry(Country c, int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		Country country = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);

			tx.commit();
			msg = "Country Updated Successfully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteCountry(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		Country country = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);

			session.remove(country);
			tx.commit();
			msg = "Country Deleted Successfully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Country> getAllCountry() {
		Session session = null;
		Transaction tx = null;
		List<Country> list = null;
		String hqlQuery = "from Country";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Country> query = session.createQuery(hqlQuery, Country.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Country getParticularCountryById(int id) {
		Session session = null;
		Transaction tx = null;

		Country country = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			country = session.get(Country.class, id);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return country;
	}

	public String addEmployee(Employee emp) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employee Addedd Successfully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public Employee login(Employee emp) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;
		String hqlQuery = "from Employee where emailid=:emailid and mobileno=:mobileno";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("emailid", emp.getEmailid());
			query.setParameter("mobileno", emp.getMobileno());
			employee = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where salary between :startSal and :endSal";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("startSal", startSal);
			query.setParameter("endSal", endSal);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public String updateEmployee(Employee e, long id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employee emp = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			emp = session.get(Employee.class, id);
			emp.setName(e.getName());
			emp.setStatus(e.getStatus());
			emp.setDepartment(e.getDepartment());
			emp.setMobileno(e.getMobileno());
			emp.setEmailid(e.getEmailid());
			emp.setCreatedBy(e.getCreatedBy());
			emp.setUpdatedBy(e.getUpdatedBy());
			emp.setCreatedDate(e.getCreatedDate());
			emp.setUpdatedDate(e.getUpdatedDate());
			emp.setSalary(e.getSalary());
			emp.setCountry(e.getCountry());
			session.merge(emp);
			session.getTransaction().commit();
			msg = "Employee Updated Successfully..";

			tx.commit();
			msg = "Employee Updated Successfully..";
		} catch (Exception f) {
			if (tx != null) {
				tx.rollback();
			}
			f.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteEmployee(long id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		Employee emp = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);

			session.remove(emp);
			tx.commit();
			msg = "Employee Deleted Successfully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Employee> getAllEmployee() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Employee getParticularEmployeeById(long id) {
		Session session = null;
		Transaction tx = null;

		Employee emp = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			emp = session.get(Employee.class, id);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emp;
	}
}
