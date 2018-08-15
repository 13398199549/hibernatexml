package org.framestudy.hibernatexml.tool;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * hibernate session 工具类
 * @author puxubo
 *
 */
public class SessionUtil {
	
	/**
	 * 声明线程变量副本空间，为每一个独立的线程，声明一个对应的Session变量
	 */
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>() {
		@Override
		protected Session initialValue() {
			// TODO Auto-generated method stub
			return sessionFactory.openSession();
		}
	};
	
	private static Session session;
	private static SessionFactory sessionFactory;
	private static Configuration configure;
	private static ServiceRegistry serviceRegistry;
	
	static {
		configure = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configure.getProperties()).build();
		sessionFactory = configure.buildSessionFactory(serviceRegistry);
	}
	
	/**
	 * 获得session
	 * @return
	 */
	public static Session getSession() {
		session = threadLocal.get();
		if(session == null) {
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
	
	
	public static Session newSession() {
		return sessionFactory.openSession();
	}
	
}
