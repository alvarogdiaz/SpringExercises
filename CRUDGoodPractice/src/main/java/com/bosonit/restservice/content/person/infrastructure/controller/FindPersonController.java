package com.bosonit.restservice.content.person.infrastructure.controller;

import com.bosonit.restservice.content.feign.TeacherClient;
import com.bosonit.restservice.content.person.infrastructure.controller.dto.output.PersonOutputDTO;
import com.bosonit.restservice.content.person.infrastructure.repository.port.FindPersonPort;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output.SimpleTeacherOutputDTO;
import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output.TeacherOutputDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("api/person")
public class FindPersonController {

    private FindPersonPort findPersonPort;
    private Environment environment;
    private TeacherClient teacherClient;

    @GetMapping("{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<PersonOutputDTO> findById(
            @PathVariable int id)
            throws Exception {
        return new ResponseEntity<>(new PersonOutputDTO(findPersonPort.findById(id)),
                HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonOutputDTO>> findByName(
            @PathVariable String name)
            throws Exception {
        return new ResponseEntity<>(findPersonPort.findByName(name).stream()
                .map(PersonOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("user/{user}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonOutputDTO>> findByUser(
            @PathVariable String user)
            throws Exception {
        return new ResponseEntity<>(findPersonPort.findByUser(user).stream()
                .map(PersonOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonOutputDTO>> findAll()
            throws Exception {
        return new ResponseEntity<>(findPersonPort.findAll().stream()
                .map(PersonOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("data")
    @Transactional(readOnly = true)
    public ResponseEntity<List<PersonOutputDTO>> getData(
            @RequestParam HashMap<String, Object> cond)
            throws Exception {
        return new ResponseEntity<>(findPersonPort.getData(cond).stream()
                .map(PersonOutputDTO::new)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("teacher/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<SimpleTeacherOutputDTO> getTeacher(@PathVariable String id) {
        /* RESTTEMPLATE
        String port;
        if (environment.getProperty("server.port") == null)
            port = "8081";
        else
            port = environment.getProperty("server.port").equals("8080") ? "8081" : "8080";

        ResponseEntity<SimpleTeacherOutputDTO> tea = new RestTemplate().getForEntity("http://localhost:" + port + "/api/teacher/" + id,
                SimpleTeacherOutputDTO.class);

        return new ResponseEntity<>(tea.getBody(), HttpStatus.OK);*/

        SimpleTeacherOutputDTO teacher = teacherClient.find(id);
        return ResponseEntity.ok().body(teacher);
    }
}
