package com.medisuply.supervisioncadenafrio.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class RequestDTO {
    
    @NotNull
    private Double temperature;
    
    @NotNull
    private String type;

    @NotNull
    private String location;
}
