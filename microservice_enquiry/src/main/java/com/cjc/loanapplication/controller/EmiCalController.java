package com.cjc.loanapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.loanapplication.model.EmiCalci;
import com.cjc.loanapplication.utility.EmiCal;

import lombok.extern.slf4j.Slf4j;
@CrossOrigin("*")
@Slf4j
@RestController
@RequestMapping("/emiCalculator")
public class EmiCalController 
{
	@PostMapping("/emiCal")
	public ResponseEntity<EmiCalci> emailcal(@RequestBody EmiCalci emical)
	{
		emical.setPerMonth(EmiCal.emiCalculator(emical.getAmount(),emical.getIntrest(),emical.getYears()));
		log.info("Emi Calculator ");
		return new ResponseEntity<EmiCalci>(emical,HttpStatus.OK);
	}

}
