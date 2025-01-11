package com.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
