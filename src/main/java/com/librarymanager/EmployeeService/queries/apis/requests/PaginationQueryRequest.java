package com.librarymanager.EmployeeService.queries.apis.requests;

import com.librarymanager.EmployeeService.queries.apis.queries.GetAllEmployeeQuery;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginationQueryRequest {
    private int page = 0;
    private int size = 10;

    public GetAllEmployeeQuery genQuery(){
        return new GetAllEmployeeQuery(page,size);
    }
}
