package com.ecrops.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
@Component
public class Deviceentry {
	@PersistenceContext
	private EntityManager entityManager;

	public Deviceentry() {
		// TODO Auto-generated constructor stub
	}

}
