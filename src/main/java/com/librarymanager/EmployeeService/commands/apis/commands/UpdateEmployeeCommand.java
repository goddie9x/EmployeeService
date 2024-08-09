package com.librarymanager.EmployeeService.commands.apis.commands;

import com.librarymanager.CommunicationStructure.commands.commands.CommandAbstract;
import com.librarymanager.EmployeeService.commands.apis.events.UpdateEmployeeEvent;
import com.librarymanager.EmployeeService.commands.apis.models.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeCommand extends CommandAbstract{
    private Employee employee;

    public UpdateEmployeeCommand(Employee employee) {
        super();
        this.employee = employee;
    }
    public UpdateEmployeeEvent genEvent(){
        return new UpdateEmployeeEvent(aggregateIdentifier,employee);
    }
}
