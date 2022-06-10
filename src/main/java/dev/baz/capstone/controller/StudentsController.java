package dev.baz.capstone.controller;

import dev.baz.capstone.service.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is the controller for the students.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // Only for the purposes of this capstone project, origins is set to any
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

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentDetails(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(studentsService.getStudentDetails(id));
    }
}
