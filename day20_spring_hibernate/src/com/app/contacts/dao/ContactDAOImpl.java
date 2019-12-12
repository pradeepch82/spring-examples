package com.app.contacts.dao;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.contacts.model.ContactPOJO;

@Repository
public class ContactDAOImpl implements ContactDAO {
	// dependency --- SF
	@Autowired
	private SessionFactory factory;
	
	public ContactDAOImpl() {
		System.out.println("in dao constr "+factory);
	}
	@PostConstruct
	public void init()
	{
		System.out.println("in dao init "+factory);
	}

	@Override
	public ContactPOJO registerContact(ContactPOJO c) {
		Integer id = (Integer) factory.getCurrentSession().save(c);
		c.setId(id);
		return c;
	}

	@Override
	public ContactPOJO validateContact(ContactPOJO c) {
		String hql = "select c from ContactPOJO c where c.email = :em and c.password = :pa";

		return (ContactPOJO) factory.getCurrentSession().createQuery(hql)
				.setParameter("em", c.getEmail())
				.setParameter("pa", c.getPassword()).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<ContactPOJO> viewAllContacts() {
		String hql="select c from ContactPOJO c";
		
		return factory.getCurrentSession().createQuery(hql).list();
	}
	@Override
	public ContactPOJO updateAddress(ContactPOJO c) {
		 System.out.println("in dao "+c);
		 factory.getCurrentSession().update(c);
		 
		 System.out.println("in dao on update "+c);
		 return c;
		 
	}
	@Override
	public ContactPOJO unsubscribeContact(int id) {
		Session ref=factory.getCurrentSession();
		System.out.println("in delete "+ref);
		ContactPOJO c=getDetails(id);
		if(c != null)
			ref.delete(c);
		else
			System.out.println("contact not found : dao");
		return c;
		
		
	}
	@Override
	public ContactPOJO getDetails(int id) {
		Session ref=factory.getCurrentSession();
		System.out.println("in get "+ref);
		return (ContactPOJO) ref.get(ContactPOJO.class, id);
	}
	

}
