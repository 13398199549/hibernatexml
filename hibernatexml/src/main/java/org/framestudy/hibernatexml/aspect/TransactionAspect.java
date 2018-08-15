package org.framestudy.hibernatexml.aspect;

import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.framestudy.hibernatexml.tool.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

/**
 * 事务切面
 * @author DELL
 *
 */
@Aspect
@Component
public class TransactionAspect {

	private Session session;
	private Transaction tx;
	
	@Pointcut(value="execution(* org.framestudy.hibernatexml.*.dao.impl.*DaoImpl.*(..))")
	private void pointcut() {}
	
	
	@Before(value="pointcut()")
	public void beforeAdvice(JoinPoint jp) {
		session = SessionUtil.getSession();
//		session = SessionUtil.newSession();
		tx = session.beginTransaction();
		Object target = jp.getTarget();
		Class<?> cls = target.getClass();
		try {
			Field field = cls.getDeclaredField("session");
			field.setAccessible(true);
			field.set(target, session);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterReturning(pointcut="pointcut()",returning="rev")
	public void afterReturningAdvice(Object rev) {
		tx.commit();
	}
	
	@AfterThrowing(pointcut="pointcut()",throwing="e")
	public void afterThrowingAdvice(Exception e) {
		e.printStackTrace();
		tx.rollback();
	}
	
}
