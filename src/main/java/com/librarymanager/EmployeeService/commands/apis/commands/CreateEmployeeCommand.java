package com.librarymanager.EmployeeService.commands.apis.commands;

import com.librarymanager.CommunicationStructure.commands.commands.CommandAbstract;
import com.librarymanager.EmployeeService.commands.apis.events.CreateEmployeeEvent;
import com.librarymanager.EmployeeService.commands.apis.models.Employee;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeeCommand extends CommandAbstract {
    private Employee employee;

    public CreateEmployeeCommand(Employee employee) {
        super();
        employee.setEmployeeId(aggregateIdentifier);
        this.employee = employee;
    }

    @Override
    public CreateEmployeeEvent genEvent() {
        return new CreateEmployeeEvent(aggregateIdentifier, employee);
    }
}
