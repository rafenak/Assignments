package com.concerto.loan.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concerto.loan.api.model.Collateral;


@Repository
public interface CollateralRepository extends CrudRepository<Collateral, String> {

}