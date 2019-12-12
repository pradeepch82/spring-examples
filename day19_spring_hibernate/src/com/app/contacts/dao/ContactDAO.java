package com.app.contacts.dao;

import java.util.Collection;

import com.app.contacts.model.ContactPOJO;

public interface ContactDAO {
	ContactPOJO registerContact(ContactPOJO c);

	ContactPOJO validateContact(ContactPOJO c);

	Collection<ContactPOJO> viewAllContacts();

}
