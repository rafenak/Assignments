package com.concerto.loan.api.model;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Loan {
	
	@Id
	private String loanId;
	private String loanType;
	private double loanAmount;
	private double interestRate;
	private double period;
	private boolean isApproval;
	private String remarks;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	//@JoinColumn(name = "loan_id")
	@JsonProperty("collaterals")
	private List<Collateral> collaterals;
	//private Set<Collateral> collaterals;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerEmailId")
	private Customer customer;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	private Employee employee;


	
}