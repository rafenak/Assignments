package com.concerto.loan.api.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concerto.loan.api.model.Customer;
import com.concerto.loan.api.model.Loan;


@Repository
public interface LoanRepository extends CrudRepository<Loan, String> {

	@Query(value = "select * from loan where employee_Id=:empId",nativeQuery = true)
	public List<Loan> findByEmployeeEmployeeId(String empId);
	
}