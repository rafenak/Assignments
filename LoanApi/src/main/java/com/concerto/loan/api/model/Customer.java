package com.concerto.loan.api.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="Customer")
public class Customer {
	
	@Id
	private String customerEmailId;
	private String customerName;
	private String customerAddress;	
	private String customerIdentity;
	private double annualIncome;
	private boolean incomeTaxReturnAttached;
	
}
