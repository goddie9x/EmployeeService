package com.librarymanager.EmployeeService.commands.apis.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymanager.EmployeeService.commands.apis.data.EmployeeRepository;
import com.librarymanager.EmployeeService.commands.apis.events.CreateEmployeeEvent;

@Component
public class CreateEmployeeEventHandler {
    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    public void on(CreateEmployeeEvent event){
        employeeRepository.save(event.getEmployee());
    }
}
