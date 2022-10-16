package com.concerto.loan.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.loan.api.dao.CollateralRepository;
import com.concerto.loan.api.dao.CustomerRepository;
import com.concerto.loan.api.dao.EmployeeRepository;
import com.concerto.loan.api.dao.LoanRepository;
import com.concerto.loan.api.model.Employee;
import com.concerto.loan.api.model.Loan;
import com.concerto.loan.api.utils.LoanConstants;
import com.concerto.loan.api.model.Collateral;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CollateralRepository collateralRepository;

	public Loan findLoanById(String loanid) {
		Optional<Loan> loan = loanRepository.findById(loanid);
		//Hibernate.initialize(loan.get().getCollaterals());
		return loan.orElseThrow(() -> new EntityNotFoundException("Loan with specified id not found"));
	}

	public Loan applyForLoan(String loanType, double loanAmount, double period, String email) {
		Loan loan = new Loan();
		loan.setLoanId("test" + loanRepository.count() + 1);
		loan.setLoanType(loanType);
		loan.setLoanAmount(loanAmount);
		loan.setInterestRate(LoanConstants.calculateInterest(period));
		loan.setPeriod(period);
		//loan.setRemarks("Approved");
		
		List<Collateral> collaterals = new ArrayList<Collateral>();

		loan.setCustomer(customerRepository.findById(email).get());
		loan.setCollaterals(collaterals);

		List<Employee> employees = new ArrayList<>();
		int i = (int) (Math.random() * (employeeRepository.count()));
		employeeRepository.findAll().forEach(employee -> employees.add(employee));
		loan.setEmployee(employees.get(i));

		loanRepository.save(loan);
		return loan;

	}

}
