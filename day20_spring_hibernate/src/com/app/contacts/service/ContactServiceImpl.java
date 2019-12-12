//service -- B.L + transaction management logic.
package com.app.contacts.service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.app.contacts.model.ContactPOJO;

@Service("contact_service")
public class ContactServiceImpl implements ContactService {
	// state -- HM
	private HashMap<String, ContactPOJO> contacts;
	private static int idCounter;

	public ContactServiceImpl() {
		System.out.println("in service constr");
		contacts = new HashMap<>();
		contacts.put("admin@gmail", new ContactPOJO("admin@gmail", "admin12#",
				0, new Date(), "admin"));
		contacts.get("admin@gmail").setId(++idCounter);
	}

	@Override
	public ContactPOJO registerContact(ContactPOJO c) {
		String em = c.getEmail();
		synchronized (contacts) {
			if (contacts.containsKey(em))
				return null;
			// register contact
			c.setId(++idCounter);
			contacts.put(em, c);
			return c;

		}
	}

	@Override
	public ContactPOJO validateContact(ContactPOJO c) {
		String em = c.getEmail();
		String pass = c.getPassword();
		synchronized (contacts) {
			if (contacts.containsKey(em))
				if (contacts.get(em).getPassword().equals(pass))
					return contacts.get(em);

			return null;
		}

	}

	@Override
	public Collection<ContactPOJO> viewAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactPOJO updateAddress(ContactPOJO c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactPOJO unsubscribeContact(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
