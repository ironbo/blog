package com.bobo.blog.dao.imp1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bobo.blog.dao.BaseDao;
import com.bobo.blog.model.User;

@Repository("userDao")
public class UserDao extends BaseDao<User> {
	public String queryPassword(String username) {
		String hql = "select password from User u where u.username = ?";
		Session session = getSession();
		Query<String> query = session.createQuery(hql, String.class);
		List<String> results = new ArrayList<>();
		results = query.setParameter(0, username).getResultList();
		if (results.isEmpty()) {
			return "";
		}
		String password = results.get(0);
		return password;
	}

	public User queryInfo(String username) {
		String hql = "from User u where u.username = ?";
		Session session = getSession();
		Query<User> query = session.createQuery(hql, User.class);
		List<User> results = new ArrayList<>();
		results = query.setParameter(0, username).getResultList();
		if (results.isEmpty()) {
			return null;
		}
		User user = results.get(0);
		return user;
	}

	public boolean IsUsernameUnique(String username) {
		String hql = "select count(1) as totalNum from User u where u.username = ?";
		Session session = getSession();
		Query<?> query = session.createQuery(hql);
		List<?> results = new ArrayList<>();
		results = query.setParameter(0, username).getResultList();
		System.out.println(results.get(0));
		String total = String.valueOf(results.get(0));
		if (total.equals("0"))
			return true;
		return false;
	}

	public boolean IsEmailUnique(String email) {
		String hql = "select count(1) as totalNum from User u where u.email = ?";
		Session session = getSession();
		Query<?> query = session.createQuery(hql);
		List<?> results = new ArrayList<>();
		results = query.setParameter(0, email).getResultList();
		System.out.println(results.get(0));
		String total = String.valueOf(results.get(0));
		if (total.equals("0"))
			return true;
		return false;
	}

	public boolean IsNickUnique(String nick) {
		String hql = "select count(1) as totalNum from User u where u.nick = ?";
		Session session = getSession();
		Query<?> query = session.createQuery(hql);
		List<?> results = new ArrayList<>();
		results = query.setParameter(0, nick).getResultList();
		System.out.println(results.get(0));
		String total = results.get(0).toString();
		if (total.equals("0"))
			return true;
		return false;
	}
}
