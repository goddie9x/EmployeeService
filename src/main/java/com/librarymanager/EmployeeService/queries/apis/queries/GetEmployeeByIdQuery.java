package com.librarymanager.EmployeeService.queries.apis.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetEmployeeByIdQuery {
    private String employeeId;
}
