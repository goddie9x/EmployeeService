package com.librarymanager.EmployeeService.commands.apis.controllers;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.librarymanager.EmployeeService.commands.apis.commands.DeleteEmployeeCommand;
import com.librarymanager.EmployeeService.commands.apis.models.Employee;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("add")
    public String addEmployee(@RequestBody Employee entity) {
        commandGateway.sendAndWait(entity.genCreateEmployeeCommand());

        return "Added employee";
    }

    @PutMapping("update")
    public String updateEmployee(@RequestBody Employee entity) {
        commandGateway.sendAndWait(entity.genUpdateEmployeeCommand());
        
        return "Update employee";
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        commandGateway.sendAndWait(new DeleteEmployeeCommand(employeeId));

        return "Deleted employee";
    }
}