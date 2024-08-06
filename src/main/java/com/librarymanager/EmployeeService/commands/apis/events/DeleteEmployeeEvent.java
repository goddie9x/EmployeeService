package com.librarymanager.EmployeeService.commands.apis.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteEmployeeEvent implements IEvent{
    private String aggregateIdentifier;
    private String employeeId;
}
