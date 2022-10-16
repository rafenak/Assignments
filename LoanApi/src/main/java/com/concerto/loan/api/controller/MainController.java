package com.concerto.loan.api.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concerto.loan.api.model.Customer;
import com.concerto.loan.api.model.Employee;
import com.concerto.loan.api.model.Loan;
import com.concerto.loan.api.response.Messages;
import com.concerto.loan.api.response.Response;
import com.concerto.loan.api.service.CustomerService;
import com.concerto.loan.api.service.EmployeeService;
import com.concerto.loan.api.service.LoanService;

@RestController
@RequestMapping("/loanapi/v1")
public class MainController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping
	public ResponseEntity<Response> homePage() {
		return ResponseEntity.status(HttpStatus.OK).body( new Response(Messages.SUCCESS,"Welcome to Loan Api"));
	}
	
	@PostMapping(path="/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Response> addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return ResponseEntity.status(HttpStatus.OK).body( new Response(Messages.SUCCESS,"Customer Added Successfully"));
	}
	
	@GetMapping("/customer/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
		System.out.println(email);
		Customer customer= customerService.findCustomerByEmail(email);
		return ResponseEntity.of(Optional.of(customer));
	}
	
	@PostMapping(path="/employee", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Response> addEmployee(@RequestBody Employee employee) {
		System.out.println(employee);
		if(employeeService.addEmployee(employee))
		return ResponseEntity.status(HttpStatus.OK).body( new Response(Messages.SUCCESS,"Employee Added Successfully"));
		else
			return ResponseEntity.status(HttpStatus.OK).body( new Response(Messages.SUCCESS,"Employee Already Exists"));
	}
	
	@GetMapping("/employee/{employeeId}")
	public ResponseEntity<Response>  searchByEmployeeById(@PathVariable String employeeId) {
		if(employeeService.searchByEmployeeById(employeeId))
				return ResponseEntity.status(HttpStatus.FOUND).body( new Response(Messages.SUCCESS,"Employee Found"));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new Response(Messages.FAILURE,"Employee Not Found"));
		
	}
	
	
	@GetMapping("/loan/{id}")
	public ResponseEntity<Loan> getLoanById(@PathVariable String id) {
		//ystem.out.println(id);
		Loan loan=loanService.findLoanById(id);
		//System.out.println(loan);
		return ResponseEntity.of(Optional.of(loan));
	}	
	
	@PostMapping("/applyloan/{email}")
	public ResponseEntity<Response> applyLoan(@RequestBody Loan loan, @PathVariable String email) throws Exception
	{
		 loanService.applyForLoan(loan.getLoanType(),
				loan.getLoanAmount(), loan.getPeriod(), email);
		 return ResponseEntity.status(HttpStatus.OK).body( new Response(Messages.SUCCESS,"Loan apply Successfully"));
	}
	
//	@PostMapping("/update/{loanid}")
//	public ResponseEntity<Response>  uploadCollaterals(@PathVariable String loanid, @RequestBody List<String> collateralIds)
//	{
//		System.out.println(collateralIds);
//		 if(loanService.uploadCollateral(loanid, collateralIds))
//			  return ResponseEntity.status(HttpStatus.OK).body( new Response(Messages.SUCCESS,"Collateral Uploaded"));
//		 return ResponseEntity.status(HttpStatus.CONFLICT).body( new Response(Messages.FAILURE,"Collateral Uploaded"));
//	}
	
	@PostMapping("/approveLoan/{employeeId}")
	public ResponseEntity<Response> approveLoan(@PathVariable String employeeId) throws Exception 
	{
		if(employeeService.searchByEmployeeById(employeeId)) {
			employeeService.approveLoan(employeeId);
			return ResponseEntity.status(HttpStatus.OK).body( new Response(Messages.SUCCESS,"Loan Status Update"));
		}
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body( new Response(Messages.FAILURE,"Loan Approve Fail"));
		}
	}
}
