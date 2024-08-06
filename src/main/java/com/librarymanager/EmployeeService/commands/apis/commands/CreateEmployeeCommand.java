package com.librarymanager.EmployeeService.commands.apis.commands;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.librarymanager.EmployeeService.commands.apis.events.CreateEmployeeEvent;
import com.librarymanager.EmployeeService.commands.apis.models.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeCommand implements ICommand {
    @TargetAggregateIdentifier
    private String aggregateIdentifier;
    private Employee employee;

    public CreateEmployeeCommand(Employee employee) {
        this.aggregateIdentifier = UUID.randomUUID().toString();
        employee.setEmployeeId(aggregateIdentifier);
        this.employee = employee;
    }

    @Override
    public CreateEmployeeEvent genEvent() {
        return new CreateEmployeeEvent(aggregateIdentifier, employee);
    }
}
