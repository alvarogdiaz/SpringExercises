package com.bosonit.restservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {

    @Value("${VAR1}")
    private String var1;
    @Value("${My.VAR2}")
    private int var2;
    @Value("${var4.try1}")
    private int try1;
    @Value("${var4.try2}")
    private int try2;
    @Value("${var3:var3 no tiene valor}")
    private String var3;

    @GetMapping("/valores")
    public ResponseEntity<String> getValues() {
        return new ResponseEntity<String>("valor de var1 es: " + var1 +
                " valor de my.var2 es: " + var2, HttpStatus.OK);
    }

    @GetMapping("/valores2")
    public ResponseEntity<String> getValues2() {
        return new ResponseEntity<String>("valor de try1 es: " + try1 +
                " valor de try2 es: " + try2, HttpStatus.OK);
    }

    @GetMapping("/var3")
    public ResponseEntity<String> getVar3() {
        return new ResponseEntity<String>("valor de var3 es: " + var3 + " " + System.getenv("var3"), HttpStatus.OK);
    }
}
