package com.bosonit.restservice.content.subject.infrastructure.controller.dto.input;

import com.bosonit.restservice.content.subject.domain.noDatabase.SaveSubject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleSubjectInputDTO implements Serializable {

    private String asignatura;
    private String comments;
    private Date finish_date;

    public SaveSubject subject(SaveSubject saveSubject) {
        saveSubject.setAsignatura(this.getAsignatura());
        saveSubject.setFinish_date(this.getFinish_date());
        saveSubject.setComments(this.getComments());

        return saveSubject;
    }
}
