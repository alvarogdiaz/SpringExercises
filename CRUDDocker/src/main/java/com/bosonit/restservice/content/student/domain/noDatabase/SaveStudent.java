package com.bosonit.restservice.content.student.domain.noDatabase;

import com.bosonit.restservice.content.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SaveStudent extends Student {
    //private Set<String> id_profesor;

    private Integer num_hours_week;
    private String comments;
    private String branch;

    public SaveStudent(Student student) {
        //this.id_profesor = student.getId_profesor();
        this.num_hours_week = student.getNum_hours_week();
        this.branch = student.getBranch();
        this.comments = student.getComments();
    }
}
