package com.librarymanager.EmployeeService.queries.apis.projections;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymanager.CommunicationStructure.queries.queries.GetEmployeeByIdQuery;
import com.librarymanager.CommunicationStructure.queries.responses.EmployeeResponse;
import com.librarymanager.EmployeeService.commands.apis.data.EmployeeRepository;
import com.librarymanager.EmployeeService.commands.apis.models.Employee;
import com.librarymanager.EmployeeService.queries.apis.queries.GetAllEmployeeQuery;

@Component
public class EmployeeProjection {
    @Autowired
    EmployeeRepository employeeRepository;

    @QueryHandler
    EmployeeResponse getEmployeeById(GetEmployeeByIdQuery query){
        EmployeeResponse result = employeeRepository.findById(query.getEmployeeId()).orElse(null).genEmployeeResponse();

        return result;
    }
    @QueryHandler
    List<Employee> getAllEmployeeWithPagination(GetAllEmployeeQuery query){
        List<Employee> result = employeeRepository.findAll(query.toPageable()).toList();

        return result;
    }
}
