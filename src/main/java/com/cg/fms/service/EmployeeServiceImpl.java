package com.cg.fms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.EmployeeDao;
import com.cg.fms.model.EmployeeModel;
import com.cg.fms.entity.EmployeeEntity;
import com.cg.fms.exception.EmployeeException;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao repo;

	public EmployeeModel entityToModel(EmployeeEntity source) {
		EmployeeModel result = null;
		if (source != null) {
			result = new EmployeeModel();
			BeanUtils.copyProperties(source, result);

		}

		return result;
	}

	public EmployeeEntity modelToEntity(EmployeeModel source) {

		EmployeeEntity result = null;
		if (source != null) {
			result = new EmployeeEntity();
			BeanUtils.copyProperties(source, result);
		}

		return result;
	}

	@Override
	public List<EmployeeModel> findAll() {
		return repo.findAll().stream().map(entity -> entityToModel(entity)).collect(Collectors.toList());
	}

	@Override
	public EmployeeModel deleteEmployee(long empId) throws EmployeeException {
		Optional<EmployeeEntity> employeeEntity = repo.findById(empId);
		if (employeeEntity.isPresent()) {
			EmployeeModel model = entityToModel(employeeEntity.get());

			repo.deleteById(empId);

			return model;
		} else {
			throw new EmployeeException("Id for Deletion is null");
		}

	}

	@Override
	public EmployeeModel saveANDupdate(EmployeeModel model) throws EmployeeException {
		EmployeeEntity employeeEntity = null;
		if (model.getEmpId() > 0) {
			employeeEntity = repo.findById(model.getEmpId()).get();
		} else {
			employeeEntity = new EmployeeEntity();
		}
		BeanUtils.copyProperties(model, employeeEntity);
		return entityToModel(repo.save(employeeEntity));
	}

	@Override
	public void addEmployee(EmployeeModel employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, employeeEntity);
		repo.save(employeeEntity);

	}

}
