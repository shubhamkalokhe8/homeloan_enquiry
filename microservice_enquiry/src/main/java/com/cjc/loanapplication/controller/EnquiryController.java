package com.cjc.loanapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.EmailForEnquiry;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.servicei.EnquiryService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/enquiry")
public class EnquiryController
{
	@Autowired
	EnquiryService enquiryservice;
	
	@PostMapping("/enquiry")
	public ResponseEntity<Enquiry> saveEnquiry(@RequestBody Enquiry e,EmailForEnquiry email)
	{
		e.setRemark("pending");
		e.setCibilScore((long)0);
		Enquiry enquiry=enquiryservice.saveEnquiry(e);
		if(enquiry!=null)
		{
			enquiryservice.sendEmail(e,email);
			log.info("Enquiey data save succesfully");
			return new ResponseEntity<Enquiry>(enquiry,HttpStatus.OK);
		}else {
			return new ResponseEntity<Enquiry>(HttpStatus.BAD_REQUEST);
		}
		
	}
	

}
