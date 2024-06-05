package com.cjc.loanapplication.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cjc.loanapplication.exceptions.EnquiryNotSaveException;
import com.cjc.loanapplication.model.EmailForEnquiry;
import com.cjc.loanapplication.model.Enquiry;
import com.cjc.loanapplication.repository.EnquiryRepository;
import com.cjc.loanapplication.servicei.EnquiryService;
@Service
public class EnquiryServiceimpl implements EnquiryService
{
	@Autowired
	EnquiryRepository enquiryRepository;
	@Autowired
	JavaMailSender send;
	@Override
	public Enquiry saveEnquiry(Enquiry e) {
		Enquiry enquiry=enquiryRepository.save(e);
		if(enquiry!=null)
		{
			return enquiry;
		}else {
			throw new EnquiryNotSaveException("Not save Data");
		}
		
	}

	@Override
	public void sendEmail(Enquiry e, EmailForEnquiry email) {
		SimpleMailMessage smm=new SimpleMailMessage();
		
		String Subject= "Loan Inquiry for";
		String Text="Dear,"+" "+e.getEnquiryName()+"We are pleased to confirm the receipt of your loan inquiry regarding [Home Loan]. Thank you for considering [Star Finance] for your financial needs.\r\n"
				+ "\r\n"
				+ "Our team is currently reviewing your inquiry and will provide you with detailed information about the loan options, terms, and conditions shortly. Should we require any additional information, one of our representatives will contact you.\r\n"
				+ "\r\n"
				+ "In the meantime, if you have any further questions or need immediate assistance, please do not hesitate to reach out to our customer service team at [9307011693] or via email at [starfinance386@gmail.com].\r\n"
				+ "\r\n"
				+ "Thank you for choosing Star Finance. We look forward to assisting you with your loan requirements.\r\n"
				+ "\r\n"
				+ "Best regards\r\n"
				+ "Star Finanace Limited,";
		smm.setSubject(Subject);
		smm.setText(Text);
		smm.setTo(e.getEmail());
		send.send(smm);
		
	}

}
