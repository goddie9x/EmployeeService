package com.librarymanager.EmployeeService.commands.apis.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.librarymanager.EmployeeService.commands.apis.commands.CreateEmployeeCommand;
import com.librarymanager.EmployeeService.commands.apis.commands.DeleteEmployeeCommand;
import com.librarymanager.EmployeeService.commands.apis.commands.ICommand;
import com.librarymanager.EmployeeService.commands.apis.commands.UpdateEmployeeCommand;
import com.librarymanager.EmployeeService.commands.apis.events.IEvent;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Aggregate
public class EmployeeAggregate {
    @AggregateIdentifier
    private String identifier;

    @CommandHandler
    public EmployeeAggregate(CreateEmployeeCommand createEmployeeCommand){
        applyEventToAggregateIdentifier(createEmployeeCommand);
    }

    @CommandHandler
    public EmployeeAggregate(UpdateEmployeeCommand updateEmployeeCommand){
        applyEventToAggregateIdentifier(updateEmployeeCommand);
    }

    @CommandHandler
    public EmployeeAggregate(DeleteEmployeeCommand deleteEmployeeCommand){
        applyEventToAggregateIdentifier(deleteEmployeeCommand);
    }

    @EventSourcingHandler
    public void on(IEvent event) {
        this.identifier = event.getAggregateIdentifier();
    }
    private void applyEventToAggregateIdentifier(ICommand command){
        AggregateLifecycle.apply(command.genEvent());
    }
}
