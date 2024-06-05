package com.cjc.loanapplication.utility;

public class EmiCal {

	public static Double emiCalculator(Double amount, Double intrest, Double years)
	{
		intrest=intrest/(12*100);
		years=years*12;
		
		return(amount*intrest*Math.pow(1+intrest,years))/(Math.pow(1+intrest,years)-1);
	}
}
