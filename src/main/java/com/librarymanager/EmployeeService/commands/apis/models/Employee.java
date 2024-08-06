package com.librarymanager.EmployeeService.commands.apis.models;

import java.util.UUID;

import com.librarymanager.EmployeeService.commands.apis.commands.CreateEmployeeCommand;
import com.librarymanager.EmployeeService.commands.apis.commands.UpdateEmployeeCommand;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String kin;
    private Boolean isDisciplined;

    public CreateEmployeeCommand genCreateEmployeeCommand() {
        this.setEmployeeId(UUID.randomUUID().toString());
        return new CreateEmployeeCommand(this);
    }

    public UpdateEmployeeCommand genUpdateEmployeeCommand(){
        return new UpdateEmployeeCommand(this);
    }
    
    public void copy(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.kin = employee.getKin();
        this.isDisciplined = employee.getIsDisciplined();
    }
}
