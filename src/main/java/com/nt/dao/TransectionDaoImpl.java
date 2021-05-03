package com.nt.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.Transections;

@Repository
public class TransectionDaoImpl implements TransectionDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public List<Transections> fatchTransection() {
		Session session = sessionFactory.openSession();
		
		String SQL_QUERY = "from Transection";
		Query query = session.createQuery(SQL_QUERY);
		List<Transections> al = query.list();
		return al;
	}

	@Override
	public void save(Transections txn) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.persist(txn);
		transaction.commit();
	}
}
