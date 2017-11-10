package com.bobo.blog.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-base.xml");
		SessionFactory sessionFactory  = (SessionFactory) context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println(session.isConnected());
		
	}
}
