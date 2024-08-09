package com.librarymanager.EmployeeService.commands.apis.commands;

import com.librarymanager.CommunicationStructure.commands.commands.CommandAbstract;
import com.librarymanager.EmployeeService.commands.apis.events.DeleteEmployeeEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteEmployeeCommand extends CommandAbstract{
    private String employeeId;

    public DeleteEmployeeCommand(String employeeId){
        super();
        this.employeeId = employeeId;
    }
    public DeleteEmployeeEvent genEvent(){
        return new DeleteEmployeeEvent(aggregateIdentifier,employeeId);
    }
}
