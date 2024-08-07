package com.librarymanager.EmployeeService.commands.apis.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeleteEmployeeEvent implements IEvent{
    private String aggregateIdentifier;
    private String employeeId;
}
