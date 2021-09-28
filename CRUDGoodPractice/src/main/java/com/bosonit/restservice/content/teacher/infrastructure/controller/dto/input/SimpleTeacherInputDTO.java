package com.bosonit.restservice.content.teacher.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleTeacherInputDTO extends TeacherInput implements Serializable {
    private Integer id_persona;
}
