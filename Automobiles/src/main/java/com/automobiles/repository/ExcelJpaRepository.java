package com.automobiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automobiles.model.ExcelData;
@Repository
public interface ExcelJpaRepository extends JpaRepository<ExcelData, Integer>{

}
