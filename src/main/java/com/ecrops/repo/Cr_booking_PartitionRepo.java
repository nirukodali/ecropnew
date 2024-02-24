package com.ecrops.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ecrops.entity.Cr_Booking_PartitionEntity;




    @Service
    public class Cr_booking_PartitionRepo {

    	private final JdbcTemplate jdbcTemplate;

    	@Autowired
    	public Cr_booking_PartitionRepo(JdbcTemplate jdbcTemplate) {
    		this.jdbcTemplate = jdbcTemplate;
    	}

    	public String findSurveyNo(String tableName, int wbvcode, String surveyno) {
    	    String queryString = "SELECT DISTINCT cr_sno FROM " + tableName + " WHERE cr_vcode = ? AND cr_sno = ?";

    	    String cr_sno = null;
    	    try {
    	        cr_sno = jdbcTemplate.queryForObject(queryString, String.class, wbvcode, surveyno);
    	    } catch (EmptyResultDataAccessException e) {
    	    e.printStackTrace();
    	    }

    	    return cr_sno;
    	}


    	    }



