package com.bosonit.restservice.content.teacher.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.person.infrastructure.controller.dto.input.PersonInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherInputDTO extends TeacherInput implements Serializable {
    private PersonInputDTO id_persona;
}
