package com.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch.entity.Annual_Enterprice_Survey_2023;

@Repository
public interface AESRepo extends JpaRepository<Annual_Enterprice_Survey_2023, Long> {

}
