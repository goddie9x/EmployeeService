package com.librarymanager.EmployeeService.commands.apis.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.librarymanager.CommunicationStructure.commands.aggreagtes.AggregateAbstract;
import com.librarymanager.EmployeeService.commands.apis.commands.CreateEmployeeCommand;
import com.librarymanager.EmployeeService.commands.apis.commands.DeleteEmployeeCommand;
import com.librarymanager.EmployeeService.commands.apis.commands.UpdateEmployeeCommand;
import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class EmployeeAggregate extends AggregateAbstract{
    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand createEmployeeCommand){
        applyEventToAggregateLifecycleFromCommand(createEmployeeCommand);
    }

    @CommandHandler
    public EmployeeAggregate(UpdateEmployeeCommand updateEmployeeCommand){
        applyEventToAggregateLifecycleFromCommand(updateEmployeeCommand);
    }

    @CommandHandler
    public EmployeeAggregate(DeleteEmployeeCommand deleteEmployeeCommand){
        applyEventToAggregateLifecycleFromCommand(deleteEmployeeCommand);
    }
}
