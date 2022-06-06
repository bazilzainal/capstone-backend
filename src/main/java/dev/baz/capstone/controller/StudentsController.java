package dev.baz.capstone.controller;

import dev.baz.capstone.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(studentsService.getStudents());
    }

    @GetMapping("/students/session/{id}")
    public ResponseEntity<?> getStudentsBySession(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(studentsService.getStudentsBySession(id));
    }
}
