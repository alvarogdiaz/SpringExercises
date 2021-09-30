package com.bosonit.restservice.content.feign;

import com.bosonit.restservice.content.teacher.infrastructure.controller.dto.output.SimpleTeacherOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="teacher", url="http://localhost:8080/api/teacher")
public interface TeacherClient {

    @GetMapping("{id}")
    SimpleTeacherOutputDTO find(@PathVariable String id);

}