package com.lti.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Phonebook;
import com.lti.repository.PhonebookDao;

@Service
public class PhonebookServiceImpl implements PhonebookService {
   
	@Autowired
	PhonebookDao dao;

	@Override
	public Phonebook createContact(Phonebook phone) {
		return dao.createContact(phone);
	}

	@Override
	public boolean deleteContact(int contactId) {
		return dao.deleteContact(contactId);
	}

	@Override
	public List<Phonebook> searchContact(String name) {
		return dao.searchContact(name);
	}

	@Override
	public List<Phonebook> viewAllContacts() {
		return dao.viewAllContacts();
	}
	
	
}
