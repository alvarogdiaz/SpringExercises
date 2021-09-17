package com.bosonit.restservice.controllers;

import com.bosonit.restservice.profile.IProfiles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BS4 {

    @Value("${url}")
    private String url;
    @Value("${password}")
    private String pass;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private IProfiles profile;

    @GetMapping("/parametros")
    public ResponseEntity<String> getUrlPass() {
        log.info("SOY INFO");
        log.error("SOY ERROR");
        log.trace("SOY TRACE");
        log.warn("SOY WARNING");
        log.debug("SOY DEBUG");
        return new ResponseEntity<>("url: " + url + "; pass: " + pass, HttpStatus.OK);
    }

    @GetMapping("/miconfiguracion")
    public ResponseEntity<String> getParamsConfig() {
        return new ResponseEntity<String>((String)context.getBean("getParams"), HttpStatus.OK);
    }

    @GetMapping("/perfil")
    public ResponseEntity<HttpStatus> getProfile() {
        profile.miFuncion();
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
