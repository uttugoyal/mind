package com.cg.fms.controllers;

import com.cg.fms.exception.*;
import com.cg.fms.model.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<EmployeeModel>> findAllEmployee() throws EmployeeException {

		return new ResponseEntity<List<EmployeeModel>>(employeeService.findAll(), HttpStatus.OK);

	}

	@PostMapping(value="/add")
	public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody EmployeeModel model) throws EmployeeException {

		return new ResponseEntity<EmployeeModel>(employeeService.saveANDupdate(model), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<EmployeeModel> deleteEmployee(@PathVariable("id") long empId) throws EmployeeException {

		return new ResponseEntity<EmployeeModel>(employeeService.deleteEmployee(empId), HttpStatus.OK);
	}

	@PutMapping(value="/edit/{id}")
	public ResponseEntity<EmployeeModel> updateEmployee(@RequestBody EmployeeModel model) throws EmployeeException {

		return new ResponseEntity<EmployeeModel>(employeeService.saveANDupdate(model), HttpStatus.CREATED);
	}

}
