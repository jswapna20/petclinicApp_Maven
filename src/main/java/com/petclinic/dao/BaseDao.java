    package com.petclinic.dao;

    import javax.annotation.Resource;
	import org.springframework.stereotype.Repository;
	import org.hibernate.SessionFactory;

	@Repository
	public class BaseDao {

	protected SessionFactory sessionFactory;

	@Resource(name= "hibernate4SessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	
	}

}