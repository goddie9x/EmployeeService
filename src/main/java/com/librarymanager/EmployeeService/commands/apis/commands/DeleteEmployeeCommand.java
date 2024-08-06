package com.librarymanager.EmployeeService.commands.apis.commands;

import java.util.UUID;

import com.librarymanager.EmployeeService.commands.apis.events.DeleteEmployeeEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteEmployeeCommand implements ICommand{
    private String aggregateIdentifier;
    private String employeeId;

    public DeleteEmployeeCommand(String employeeId){
        this.employeeId = employeeId;
        this.aggregateIdentifier = UUID.randomUUID().toString();
    }
    public DeleteEmployeeEvent genEvent(){
        return new DeleteEmployeeEvent(aggregateIdentifier,employeeId);
    }
}
