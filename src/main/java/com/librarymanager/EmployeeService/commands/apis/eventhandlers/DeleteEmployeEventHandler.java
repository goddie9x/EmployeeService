package com.librarymanager.EmployeeService.commands.apis.eventhandlers;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.librarymanager.EmployeeService.commands.apis.data.EmployeeRepository;
import com.librarymanager.EmployeeService.commands.apis.events.DeleteEmployeeEvent;

@Component
public class DeleteEmployeEventHandler {
    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    public void on(DeleteEmployeeEvent event){
        employeeRepository.deleteById(event.getEmployeeId());
    }
}
