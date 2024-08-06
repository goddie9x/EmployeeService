package com.librarymanager.EmployeeService.commands.apis.events;

import com.librarymanager.EmployeeService.commands.apis.models.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateEmployeeEvent implements IEvent {
    private String aggregateIdentifier;
    private Employee employee;
}
