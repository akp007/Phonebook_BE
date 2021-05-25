package com.lti.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Phonebook;
import com.lti.service.PhonebookService;

@RestController
@CrossOrigin
public class PhonebookController {
	
	@Autowired
	PhonebookService service;
	
	//http://localhost:9090/createContact
	@RequestMapping(value="/createContact",method = RequestMethod.POST)
	public Phonebook createContact(@RequestBody Phonebook phone) {
	   Phonebook pb = service.createContact(phone);
	   return pb;
	}
	
	//http://localhost:9090/deleteContact
    @RequestMapping(value="/deleteContact",method = RequestMethod.POST)
	public boolean deleteContact(@RequestBody int contactId) {
		return service.deleteContact(contactId);
	}
	
   //http://localhost:9090/searchContact?firstName=
    @RequestMapping(value="/searchContact")
	public List<Phonebook> searchContact(@RequestParam("firstName") String firstName){
		return service.searchContact(firstName);
	}
    
	//http://localhost:9090/viewAllContacts
	@RequestMapping(value="/viewAllContacts")
   	public List<Phonebook> viewAllContacts(){
   		return service.viewAllContacts();
   	}
}
