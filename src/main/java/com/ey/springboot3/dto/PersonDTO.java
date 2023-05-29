package com.ey.springboot3.dto;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record PersonDTO(

        @Min(1)
        @NotNull
        Integer id,
        String name,
        String description,
        boolean status) {
}
