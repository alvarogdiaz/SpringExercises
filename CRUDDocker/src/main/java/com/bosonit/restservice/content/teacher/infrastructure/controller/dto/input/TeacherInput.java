package com.bosonit.restservice.content.teacher.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.teacher.domain.noDatabase.SaveTeacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class TeacherInput implements Serializable {
    private String comments;
    private String branch;

    public SaveTeacher profesor(SaveTeacher saveTeacher) {
        saveTeacher.setComments(this.comments);
        saveTeacher.setBranch(this.branch);

        return saveTeacher;
    }
}
