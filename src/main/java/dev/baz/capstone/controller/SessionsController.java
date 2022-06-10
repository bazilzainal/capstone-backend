package dev.baz.capstone.controller;

import dev.baz.capstone.entities.SessionsEntity;
import dev.baz.capstone.service.SessionsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * This class is the controller for sessions.
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600) // Only for the purposes of this capstone project, origins is set to any
public class SessionsController {

    private final SessionsService sessionsService;

    public SessionsController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @GetMapping("/sessions")
    public ResponseEntity<?> getSessions() {
        return ResponseEntity.ok(sessionsService.getSessions());
    }

    @GetMapping("/sessions/instructor/{id}")
    public ResponseEntity<?> getSessionsByInstructor(@PathVariable Integer id) {
        return ResponseEntity.ok(sessionsService.getSessionsByInstructor(id));
    }

    @GetMapping("/sessions/{id}")
    public ResponseEntity<?> getSessionDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(sessionsService.getSessionDetails(id));
    }

    @GetMapping("/sessions/date/{date}")
    public ResponseEntity<?> getSessionsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.ok(sessionsService.getSessionsByDate(date));
    }

    @GetMapping("/sessions/student/{id}")
    public ResponseEntity<?> getAllStudentSessionDetails(@PathVariable Integer id) {
        return ResponseEntity.ok(sessionsService.getAllStudentSessionDetails(id));
    }

    @PostMapping("/sessions")
    public ResponseEntity<?> saveSession(@RequestBody SessionsEntity session) {
        return ResponseEntity.ok(sessionsService.save(session));
    }

}
