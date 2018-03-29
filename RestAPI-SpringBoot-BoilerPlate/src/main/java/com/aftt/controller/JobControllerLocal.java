package com.aftt.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aftt.dao.JobDaoLocal;
import com.aftt.dto.JobLocal;

@RestController
@RequestMapping( value = "/joblocal")
public class JobControllerLocal {	
	
	@Autowired
	private JobDaoLocal jobDao;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<JobLocal> getJobs(){
		return jobDao.getJobs();
	}
}
