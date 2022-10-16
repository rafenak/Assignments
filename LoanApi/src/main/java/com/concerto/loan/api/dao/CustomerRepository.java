package com.concerto.loan.api.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.concerto.loan.api.model.Customer;


@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String> {


}