package com.librarymanager.EmployeeService.commands.apis.commands;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.librarymanager.EmployeeService.commands.apis.events.UpdateEmployeeEvent;
import com.librarymanager.EmployeeService.commands.apis.models.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEmployeeCommand implements ICommand{
    @TargetAggregateIdentifier
    private String aggregateIdentifier;
    private Employee employee;

    public UpdateEmployeeCommand(Employee employee) {
        this.aggregateIdentifier = UUID.randomUUID().toString();
        this.employee = employee;
    }
    public UpdateEmployeeEvent genEvent(){
        return new UpdateEmployeeEvent(aggregateIdentifier,employee);
    }
}
