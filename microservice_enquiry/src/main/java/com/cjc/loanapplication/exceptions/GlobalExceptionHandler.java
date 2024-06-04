package com.cjc.loanapplication.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler  {

	@ExceptionHandler(EnquiryNotSaveException.class)
	public ResponseEntity<APIError> enquiryNotSaveDataExceptionHandller(EnquiryNotSaveException e,HttpServletRequest http)
	{
		APIError apierror=new APIError();
		apierror.setDate(new Date());
		apierror.setStatuscode(HttpStatus.BAD_REQUEST.value());
		apierror.setMessage(e.getMessage());
		apierror.setPath(http.getRequestURI());
		apierror.setHttpmessage(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<APIError>(apierror,HttpStatus.BAD_REQUEST);
	}
	
}
