package dev.baz.capstone.controller;

import dev.baz.capstone.service.InstructorsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorsController {

    private final InstructorsService instructorsService;

    public InstructorsController(InstructorsService instructorsService) {
        this.instructorsService = instructorsService;
    }

    @GetMapping("/instructors")
    public ResponseEntity<?> getInstructors() {
        return ResponseEntity.ok(instructorsService.getInstructors());
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<?> getInstructor(@PathVariable Integer id) {
        return ResponseEntity.ok(instructorsService.getInstructor(id));
    }
}
