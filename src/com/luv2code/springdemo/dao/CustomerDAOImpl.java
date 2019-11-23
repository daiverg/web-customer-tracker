package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

//	inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> getCustomers() {
//		current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
//		query & sort by Last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",
																Customer.class);
		
		
//		execute query and get result
		List<Customer> customers = theQuery.getResultList();
		
//		return result
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
//	get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
//		save the customer to DB
		currentSession.save(theCustomer);
		
	}

}
