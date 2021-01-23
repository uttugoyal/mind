package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.fms.entity.*;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Long> {

}
