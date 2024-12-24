package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Person;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class PersonDao {

	@Autowired
	SessionFactory factory;

	public String addRecord(Person p) {

		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(p);
			tx.commit();
			msg = "Person Added Successfully...";

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

	public String updateRecord(Person p, int id) {

		Session session = null;
		Transaction tx = null;
		Person person = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			person = session.get(Person.class, id);
			person.setName(p.getName());
			person.setAge(p.getAge());
			person.setGender(p.getGender());
			person.setCity(p.getCity());

			session.merge(person);
			tx.commit();
			msg = "Person Updated Successfully...";

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

	public String deleteRecord(int id) {
		Session session = null;
		Transaction tx = null;
		Person person = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			person = session.get(Person.class, id);

			session.remove(person);
			tx.commit();
			msg = "Person is Deleted Successfully...";
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

	public List<Person> getAllRecord() {

		Session session = null;
		Transaction tx = null;
		List<Person> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

	/*		Using Hibernate Functions

			HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
			Root<Person> root = criteria.from(Person.class);
			criteria.select(root);

			Query<Person> query = session.createQuery(criteria);
			List<Person> list = query.getResultList();
	*/

	/*      Using Hibernate Query   */

			String hqlQuery = "from Person";

			Query<Person> query = session.createQuery(hqlQuery, Person.class);
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

	public Person getPraticularRecordById(int id) {
		
		Session session = null;
		Transaction tx = null;
		Person person = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			person = session.get(Person.class, id);
			tx.commit();
		}catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return person;
	}

	public Person getPraticularRecordByCity(String city) {
		
		Session session = null;
		Transaction  tx = null;
		Person person = null;
		String hqlQuery = "from Person where city=:city";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Person> query = session.createQuery(hqlQuery, Person.class);
			query.setParameter("city", city);
			
			person = query.uniqueResult();
			tx.commit();
			
		}catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return person;
	}

	public Person loginCheck(Person p) {

		Session session = null;
		Transaction tx = null;
		String hqlQuery = "from Person where id=:id and city=:city";
		Person person = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Person> query = session.createQuery(hqlQuery, Person.class);
			query.setParameter("id", p.getId());
			query.setParameter("city", p.getCity());

			person = query.uniqueResult();
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
		return person;
	}
}
