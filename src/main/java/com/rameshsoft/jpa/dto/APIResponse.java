package com.rameshsoft.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor  //not working
//@NoArgsConstructor
public class APIResponse<T> {
    int recordCount;  //count the record from database
    T response;

    public APIResponse(int recordCount, T response) {
        this.recordCount = recordCount;
        this.response = response;
    }
}
