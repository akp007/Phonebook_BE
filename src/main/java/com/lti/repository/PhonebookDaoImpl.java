package com.lti.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.lti.model.Phonebook;


@Repository
public class PhonebookDaoImpl implements PhonebookDao {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Phonebook createContact(Phonebook phone) {
	  Phonebook pb = new Phonebook();
	  pb.setFirstName(phone.getFirstName());
	  pb.setLastName(phone.getLastName());
	  pb.setContact(phone.getContact());
	  pb = em.merge(pb);
	  return pb;
	}
	
	@Transactional
	public boolean deleteContact(int contactId) {
		Phonebook pb = em.find(Phonebook.class, contactId);
		em.remove(pb);
		return true;
	}
	
	public List<Phonebook> searchContact(String name){
		String nameTitle = StringUtils.capitalize(name);
		//System.out.println(name);
		String jpql = "Select p from Phonebook p where p.firstName LIKE '%'||:name||'%' or p.lastName LIKE '%'||:name||'%'";
		TypedQuery<Phonebook> query = em.createQuery(jpql,Phonebook.class);
		query.setParameter("name", nameTitle);
		List<Phonebook> pb = query.getResultList();
		return pb;
	}
    
	@Override
	public List<Phonebook> viewAllContacts() {
		String jpql = "select p from Phonebook p order by p.firstName asc";
		TypedQuery<Phonebook> query = em.createQuery(jpql,Phonebook.class);
		List<Phonebook> pb = query.getResultList();

		return pb;
	}
	

}
