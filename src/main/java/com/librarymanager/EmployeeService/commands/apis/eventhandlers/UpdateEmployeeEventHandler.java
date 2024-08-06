package com.librarymanager.EmployeeService.commands.apis.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymanager.EmployeeService.commands.apis.data.EmployeeRepository;
import com.librarymanager.EmployeeService.commands.apis.events.UpdateEmployeeEvent;
import com.librarymanager.EmployeeService.commands.apis.models.Employee;

@Component
public class UpdateEmployeeEventHandler {
    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    public void on(UpdateEmployeeEvent event){
        Employee updateEmployeeData = event.getEmployee();
        Employee target = employeeRepository.findById(updateEmployeeData.getEmployeeId()).orElseThrow();

        target.copy(updateEmployeeData);
        employeeRepository.save(target);
    }
}
