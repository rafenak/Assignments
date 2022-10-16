package com.concerto.loan.api.utils;

import java.util.Arrays;
import java.util.List;

import com.concerto.loan.api.model.Collateral;

public class LoanConstants {

	public static final List<Collateral> COLLATERAL_TYPE = Arrays.asList(new Collateral("1", "Vehicle Registration"),
			new Collateral("2", "House Doucments"), new Collateral("3", "Insurance Documents"),
			new Collateral("4", "Fixed Deposit"));


	public static final List<String> LOAN_TYPE = Arrays.asList("Buying Home", "Vehicle","Education","Marriage", "Hospitalization");
	
	public static double calculateInterest(double period) {
		if(period <= 2)
			return 0.05;
		else if(period >2 && period <5)
			return 0.06;
		else if(period >=5 && period < 8)
			return 0.08;
		else
			return 0.085;
	}

}
