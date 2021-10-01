package com.bosonit.restservice.content.teacher.domain.noDatabase;

import com.bosonit.restservice.content.teacher.domain.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveTeacher extends Teacher {

    private String comments;
    private String branch;

    public SaveTeacher(Teacher teacher) {
        this.branch = teacher.getBranch();
        this.comments = teacher.getComments();
    }
}
