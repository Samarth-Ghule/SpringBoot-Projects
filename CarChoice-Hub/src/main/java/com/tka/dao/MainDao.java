package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Car;
import com.tka.entity.Customer;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	public String addCar(Car c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg = "Car Added Successfully...";
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

	public String updateCar(Car c, int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		Car car = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			car = session.get(Car.class, id);
			car.setFuelType(c.getFuelType());
			car.setEnginePower(c.getEnginePower());
			car.setPrice(c.getPrice());
			session.merge(car);
			tx.commit();
			msg = "Car Updated Successfully...";
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

	public String deleteCar(int id) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		Car car = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			car = session.get(Car.class, id);
			session.remove(car);
			tx.commit();
			msg = "Car is Deleted...";

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

	public List<Car> getAllCar() {
		Session session = null;
		Transaction tx = null;
		List<Car> clist = null;
		String hqlQuery = "from Car";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			/*
			 * Using Hibernate Functions
			 * 
			 * HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
			 * CriteriaQuery<Car> criteria = builder.createQuery(Car.class); 
			 * Root<Car> root = criteria.from(Car.class);
		     * criteria.select(root);
			 * Query<Car> query = session.createQuery(criteria); 
			 * clist = query.getResultList();
			 */

			/* Using HQL Query */

			Query<Car> query = session.createQuery(hqlQuery, Car.class);
			clist = query.list();

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
		return clist;
	}

	public Car getParticularCarById(int id) {

		Session session = null;
		Transaction tx = null;
		Car car = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			car = session.get(Car.class, id);
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
			return car;
		}

	}

	public String addCustomer(Customer cm) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.merge(cm);
			tx.commit();
			msg = "Customer Added Successfully...";

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

	public Customer login(Customer c) {

		Session session = null;
		Transaction tx = null;
		Customer customer = null;
		String hqlQuery = "from Customer where email = :email and phoneNumber = :phoneNumber";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Customer> query = session.createQuery(hqlQuery, Customer.class);
			query.setParameter("email", c.getEmail());
			query.setParameter("phoneNumber", c.getPhoneNumber());
			customer = query.uniqueResult();
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
		return customer;
	}

	public String updateCustomer(Customer c, int id) {

		Session session = null;
		Transaction tx = null;
		Customer customer = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			customer = session.get(Customer.class, id);
			customer.setFullName(c.getFullName());
			customer.setEmail(c.getEmail());
			customer.setPhoneNumber(c.getPhoneNumber());
			customer.setAddress(c.getAddress());
			customer.setPinCode(c.getPinCode());
			customer.setPaymentMethod(c.getPaymentMethod());
			customer.setLoanApprovalStatus(c.getLoanApprovalStatus());
			customer.setCar(c.getCar());

			session.merge(customer);
			tx.commit();
			msg = "Customer Updated Successfully...";

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

	public String deleteCustomer(int id) {
		Session session = null;
		Transaction tx = null;
		Customer customer = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			customer = session.get(Customer.class, id);

			session.remove(customer);
			tx.commit();

			msg = "Customer is Deleted...";

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

	public List<Customer> getAllCustomer() {
		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Customer";
		List<Customer> clist = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			/* Using Hibernate Functions */

			HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
			Root<Customer> root = criteria.from(Customer.class);
			criteria.select(root);
			Query<Customer> query = session.createQuery(criteria);
			clist = query.getResultList();

			/*
			  Using HQL Query 
			  
			  Query<Customer> query = session.createQuery(hqlQuery,Customer.class); 
			  clist = query.list();
			  
			 */
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
		return clist;
	}

	public Customer getCustomerById(int id) {

		Session session = null;
		Transaction tx = null;
		Customer customer = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			customer = session.get(Customer.class, id);
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

		return customer;
	}
/*
	
	public List<Customer> getCustomerByLoanApprovalStatus(String loanApprovalStatus) {
		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Customer where loanApprovalStatus= :status";
		List<Customer> clist = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			
			Query<Customer> query = session.createQuery(hqlQuery, Customer.class);

			query.setParameter("status", loanApprovalStatus );
			clist = query.list();
			
			tx.commit();
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}
		return clist;
	}
	
*/
}
