package com.cjc.loanapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmiCalci {

	private Double amount;
	private Double intrest;
	private Double years;
	private Double perMonth;
}
