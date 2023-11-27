package com.example.TrainingInstitute.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainingInstitute.Model.Employee;
import com.example.TrainingInstitute.Repository.EmployeeRepository;

@Service 
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository respo;

	@Override
	public List<Employee> showAllDetails() {
		
		return respo.findAll();
	}

	@Override
	public Employee addNewEmployee(Employee emp) {
	
		return respo.save(emp);
	}

	@Override
	public Optional<Employee> searchemp(long empid) {
		
		return respo.findById(empid);
	}

	@Override
	public void deletePage(long emid) {
		
		respo.deleteById(emid);
		
	}
	
	
	
	

}
