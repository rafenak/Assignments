package com.concerto.loan.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concerto.loan.api.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

}