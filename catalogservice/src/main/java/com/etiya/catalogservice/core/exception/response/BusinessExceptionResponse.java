package com.etiya.catalogservice.core.exception.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessExceptionResponse {
    private int status;
    private String error;
}
