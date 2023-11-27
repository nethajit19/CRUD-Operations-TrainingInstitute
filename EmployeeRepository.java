package com.example.TrainingInstitute.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TrainingInstitute.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> 
{

}
