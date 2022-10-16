package com.concerto.loan.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ToString
@Entity
@Table(name="Collateral")
public class Collateral {
	@Id
	private String collateralId;
	private String collateralType;
	
//	//@ManyToOne
//    @JoinColumn(name="loan_id",insertable = false, updatable = false)
//	private String loanId;
}
