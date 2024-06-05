package com.cjc.loanapplication.servicei;

import com.cjc.loanapplication.model.EmailForEnquiry;
import com.cjc.loanapplication.model.Enquiry;

public interface EnquiryService {

	Enquiry saveEnquiry(Enquiry e);

	void sendEmail(Enquiry e, EmailForEnquiry email);

}
