package com.example.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bean.Test;

@Repository
// @Service("testDAO")
public class TestDaoImp implements TestDao {

	@Autowired
	private SessionFactory sessionFactory;

	// private final Class<T> persistentClass;
	//
	// @SuppressWarnings("unchecked")
	// public TestDAO(){
	// this.persistentClass =(Class<T>) ((ParameterizedType)
	// this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	// }

	// public void setSessionFactory(SessionFactory sf) {
	// this.sessionFactory = sf;
	// }

	@Override
	@Transactional
	public void addTest(Test test) {
		// Session session = this.sessionFactory.getCurrentSession();
		// session.persist(test);

		sessionFactory.getCurrentSession().save(test);
		//sessionFactory.close();
	}

}
