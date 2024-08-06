package com.librarymanager.EmployeeService.queries.apis.controllers;

import java.util.List;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanager.EmployeeService.commands.apis.models.Employee;
import com.librarymanager.EmployeeService.queries.apis.queries.GetEmployeeByIdQuery;
import com.librarymanager.EmployeeService.queries.apis.requests.PaginationQueryRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping()
    public List<Employee> getAllEmployeeWithPagination(PaginationQueryRequest request) {
        List<Employee> response = queryGateway
                .query(request.genQuery(), ResponseTypes.multipleInstancesOf(Employee.class)).join();

        return response;
    }

    @GetMapping("/{employeeId}")
    public Employee getMethodName(@PathVariable String employeeId) {
        GetEmployeeByIdQuery query = new GetEmployeeByIdQuery(employeeId);
        Employee response = queryGateway.query(query, ResponseTypes.instanceOf(Employee.class)).join();

        return response;
    }

}
