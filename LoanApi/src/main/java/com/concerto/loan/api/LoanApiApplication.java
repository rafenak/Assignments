package com.concerto.loan.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.concerto.loan.api.dao.CollateralRepository;
import com.concerto.loan.api.dao.LoanRepository;
import com.concerto.loan.api.model.Collateral;
import com.concerto.loan.api.model.Customer;
import com.concerto.loan.api.model.Employee;
import com.concerto.loan.api.model.Loan;
import com.concerto.loan.api.service.EmployeeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LoanApiApplication {
	
	@Autowired 
	private LoanRepository loanRepository;
	
	@Autowired
	private CollateralRepository collateralRepository;
	
	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(LoanApiApplication.class, args);
	}
	
	@Bean
	public void initialize() {
		//Adding Customer
		Customer cust = new Customer();		
		cust.setCustomerName("Rafe");
		cust.setCustomerAddress("Mumbai");
		cust.setCustomerEmailId("nakhudarafe@gmail.com");
		cust.setCustomerIdentity("100");
		cust.setAnnualIncome(20000.0);
		cust.setIncomeTaxReturnAttached(true);
		

		Collateral co1 = new Collateral();
		co1.setCollateralId("601");
		co1.setCollateralType("Insurance Documents");
		//co1.setLoanId(loan.getLoanId());
		collateralRepository.save(co1);
		
		Collateral co2 = new Collateral();
		co2.setCollateralId("602");
		co2.setCollateralType("Fixed Deposit");
		//co2.setLoanId(loan.getLoanId());
		collateralRepository.save(co2);
		
		
		
		Employee emp=new Employee();
		emp.setEmployeeId(501+"");
		emp.setEmployeeName("Employee"+501);
		
		Loan loan = new Loan();
		loan.setLoanId("301");
		loan.setLoanType("Education");
		loan.setLoanAmount(20000.0);
		loan.setInterestRate(8.0);
		loan.setPeriod(3.0);
		loan.setApproval(true);
		loan.setRemarks("Test Remarks");
		loan.setCustomer(cust);
		loan.setEmployee(emp);	
		List<Collateral> collaterals = new ArrayList<Collateral>();
		collaterals.add(co1);
		collaterals.add(co2);
		loan.setCollaterals(collaterals);
		loanRepository.save(loan);
		
		
		
		
		
		
	
		
		for(int i=1;i<=10;i++) {
			Employee e=new Employee();
			e.setEmployeeId(""+i);
			e.setEmployeeName("Employee"+(i));
			this.employeeService.addEmployee(e);
		}		
		
		
	}

}
