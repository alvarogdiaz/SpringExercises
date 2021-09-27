package com.bosonit.restservice.content.student.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.persona.infrastructure.controller.dto.input.PersonaInputDTO;
import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInputDTO {

    private PersonaInputDTO id_persona;
    private Integer num_hours_week;
    private String comments;
    private String branch;

    public SaveStudent student(SaveStudent saveStudent) {
        saveStudent.setNum_hours_week(this.num_hours_week);
        saveStudent.setComments(this.comments);
        saveStudent.setBranch(this.branch);

        return saveStudent;
    }
}
