package com.bosonit.restservice.content.student.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.student.domain.noDatabase.SaveStudent;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class StudentInput implements Serializable {
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
