package com.ey.springboot3.controller;

import com.ey.springboot3.dto.PersonDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/demo")
public class PersonController {

    //este es un comentario de prueba

    @GetMapping
    public ResponseEntity<?> sayHello(){

        String textBlock = """
                Hola mundo esta es \
                una prueba  \
                para la demo \
                de springboot 3  
                con java 17
                """;

        return new ResponseEntity<>(
                new PersonDTO(1, "Juan", textBlock, true), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveSomething(@Valid @RequestBody PersonDTO personDTO){

        if(personDTO.id() > 2 ){
            return ResponseEntity.ok().body(personDTO);
        }else{
            ProblemDetail pd =
                    ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "Id es menor que 2");
            pd.setType(URI.create("http://localhost:8080/demo"));
            pd.setTitle("Record Id es menor que 2");
            pd.setProperty("hostname", "localhost:8080");

            return ResponseEntity.status(404).body(pd);
        }

    }
}
