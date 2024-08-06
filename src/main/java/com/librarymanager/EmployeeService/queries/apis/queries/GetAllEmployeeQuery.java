package com.librarymanager.EmployeeService.queries.apis.queries;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEmployeeQuery {
    private int page = 0;
    private int size = 10;

    public Pageable toPageable(){
        return PageRequest.of(page,size);
    }
}
