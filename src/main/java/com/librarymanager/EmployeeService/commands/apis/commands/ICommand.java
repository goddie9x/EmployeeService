package com.librarymanager.EmployeeService.commands.apis.commands;

import com.librarymanager.EmployeeService.commands.apis.events.IEvent;

public interface ICommand {
    public IEvent genEvent();
}
