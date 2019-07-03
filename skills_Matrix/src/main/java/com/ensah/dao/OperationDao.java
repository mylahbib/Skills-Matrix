package com.ensah.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.entity.Operation;

public interface OperationDao extends JpaRepository<Operation, Long>{
}
