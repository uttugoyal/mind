package com.cg.fms.service;

import java.util.List;

import com.cg.fms.exception.EmployeeException;
import com.cg.fms.model.*;

public interface EmployeeService {

	public List<EmployeeModel> findAll() throws EmployeeException;

	public EmployeeModel saveANDupdate(EmployeeModel employee) throws EmployeeException;

	public void addEmployee(EmployeeModel employee);

	public EmployeeModel deleteEmployee(long EmpId) throws EmployeeException;
}
