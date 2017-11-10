package com.bobo.blog.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("baseDao")
public class BaseDao<T> implements AbstractDao<T> {

	protected SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public T get(int id,Class<T> t) {
		Session session = getSession();
		T t2 = (T) session.get(t, id);
		return t2;
	}
	
	@Override
	public void save(T t) {
		Session session = getSession();
		session.save(t);
	}

	@Override
	public void update(T t) {
		Session session = getSession();
		session.save(t);
		
	}

	@Override
	public void delete(T t) {
		Session session = getSession();
		session.delete(t);	
	}


}
