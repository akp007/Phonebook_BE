package com.lti.service;

import java.util.List;
import java.util.Set;

import com.lti.model.Phonebook;

public interface PhonebookService {
   
	public Phonebook createContact(Phonebook phone);
	public boolean deleteContact(int contactId);
	public List<Phonebook> searchContact(String name);
	public List<Phonebook> viewAllContacts();
}
