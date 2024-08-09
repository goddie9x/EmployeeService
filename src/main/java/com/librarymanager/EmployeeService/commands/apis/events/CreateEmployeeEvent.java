package com.librarymanager.EmployeeService.commands.apis.events;

import com.librarymanager.CommunicationStructure.commands.events.IEvent;
import com.librarymanager.EmployeeService.commands.apis.models.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateEmployeeEvent implements IEvent{
    private String aggregateIdentifier;
    private Employee employee;
}
