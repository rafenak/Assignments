package com.concerto.loan.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concerto.loan.api.dao.CustomerRepository;
import com.concerto.loan.api.dao.EmployeeRepository;
import com.concerto.loan.api.dao.LoanRepository;
import com.concerto.loan.api.model.Customer;
import com.concerto.loan.api.model.Employee;
import com.concerto.loan.api.model.Loan;

@Service
public class EmployeeService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private LoanRepository loanRepository;

	public boolean addEmployee(Employee employee) {
		if (!employeeRepository.existsById(employee.getEmployeeId())) {
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}

	public boolean searchByEmployeeById(String employeeId) {
		if (employeeRepository.existsById(employeeId))
			return true;
		return false;
	}

	public void approveLoan(String employeeId) throws Exception {
		if (searchByEmployeeById(employeeId)) {
			List<Loan> loans = loanRepository.findByEmployeeEmployeeId(employeeId);
			System.out.println(loans);
			if (loans.size() > 0) {
				for (Loan loan : loans) {
					Customer customer = loan.getCustomer();
					if (loan.getLoanAmount() > (10 * customer.getAnnualIncome())) {
						loan.setRemarks("Loan amount cannot be 10 times of annual income");
						loan.setApproval(false);
						loanRepository.save(loan);
					} else if (loan.getCollaterals() == null || loan.getCollaterals().size() == 0) {
						loan.setRemarks("No collateral submitted");
						loan.setApproval(false);
						loanRepository.save(loan);
					} else if (!customer.isIncomeTaxReturnAttached()) {
						loan.setRemarks("Income proof not attached");
						loan.setApproval(false);
						loanRepository.save(loan);
					} else if (customer.getCustomerIdentity() == null) {
						loan.setRemarks("Identity document not submitted");
						loan.setApproval(false);
						loanRepository.save(loan);
					} else {
						loan.setRemarks("Approved");
						loan.setApproval(true);
						loanRepository.save(loan);
					}
					System.out.println(loans);
				}
			} else {
				throw new Exception("No loan proposals from this employee id");
			}
		} else
			throw new EntityNotFoundException("Employee does not exist");
	}

}
