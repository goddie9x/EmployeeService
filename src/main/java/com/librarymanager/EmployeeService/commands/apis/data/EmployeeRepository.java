package com.librarymanager.EmployeeService.commands.apis.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanager.EmployeeService.commands.apis.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
