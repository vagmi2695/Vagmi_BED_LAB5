package com.arpit.sm.service;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arpit.sm.entity.Student;


@Repository
public class StudServiceImpl implements StudService {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	StudServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	
	@Transactional
	public List<Student> findAll() {
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
		List<Student> student = session.createQuery("from Student").list();

		tx.commit();

		return student;
	}
	
	
	@Transactional
	public Student findById(int id) {

		Student student = new Student();

		
		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		student = session.get(Student.class, id);

		tx.commit();

		return student;
	}

	@Transactional
	public void save(Student theStudent) {

		
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theStudent);

		tx.commit();

	}
	
	@Transactional
	public void deleteById(int id) {

	
		Transaction tx = session.beginTransaction();

		// get transaction
		Student student = session.get(Student.class, id);

		// delete record
		session.delete(student);

		tx.commit();

	}
}
