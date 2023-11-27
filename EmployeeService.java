package com.example.TrainingInstitute.Service;

import java.util.List;
import java.util.Optional;

import com.example.TrainingInstitute.Model.Employee;

public interface EmployeeService {
	
	List<Employee> showAllDetails();
	
	Employee addNewEmployee(Employee emp);
	
	Optional<Employee> searchemp(long empid);
	
	void deletePage(long emid);

}
