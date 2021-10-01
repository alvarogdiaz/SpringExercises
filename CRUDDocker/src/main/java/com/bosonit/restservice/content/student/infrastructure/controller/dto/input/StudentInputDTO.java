package com.bosonit.restservice.content.student.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.person.infrastructure.controller.dto.input.PersonInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDTO extends StudentInput implements Serializable {
    private PersonInputDTO id_persona;
}
