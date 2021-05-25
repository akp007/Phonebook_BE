package com.lti.repository;

import java.util.List;
import java.util.Set;

import com.lti.model.Phonebook;

public interface PhonebookDao {
    
	public Phonebook createContact(Phonebook phone);
	public boolean deleteContact(int contactId);
	public List<Phonebook> viewAllContacts();
	public List<Phonebook> searchContact(String name);
    
}
