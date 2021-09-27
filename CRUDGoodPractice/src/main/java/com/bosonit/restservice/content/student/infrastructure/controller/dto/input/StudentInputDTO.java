package com.bosonit.restservice.content.student.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDTO extends StudentInput implements Serializable {
    private PersonaInputDTO id_persona;
}
