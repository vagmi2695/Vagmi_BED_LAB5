package com.vagmi.sm.service;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vagmi.sm.entity.Employee;


@Repository
public class EmpServiceImpl implements EmpService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	EmpServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	
	@Transactional
	public List<Employee> findAll() {
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Employee> employee = session.createQuery("from Employee").list();

		tx.commit();

		return employee;
	}
	
	
	@Transactional
	public Employee findById(int id) {

		Employee employee = new Employee();

		
		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		employee = session.get(Employee.class, id);

		tx.commit();

		return employee;
	}

	@Transactional
	public void save(Employee theEmployee) {

		
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theEmployee);

		tx.commit();

	}
	
	@Transactional
	public void deleteById(int id) {

	
		Transaction tx = session.beginTransaction();

		// get transaction
		Employee employee = session.get(Employee.class, id);

		// delete record
		session.delete(employee);

		tx.commit();

	}
}
