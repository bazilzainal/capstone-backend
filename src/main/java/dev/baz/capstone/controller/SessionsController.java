package dev.baz.capstone.controller;

import dev.baz.capstone.entities.SessionsEntity;
import dev.baz.capstone.service.SessionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
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
    public ResponseEntity<?> getSessionByInstructor(@PathVariable Integer id) {
        return ResponseEntity.ok(sessionsService.getSessionByInstructor(id));
    }

    @PostMapping("/sessions")
    public ResponseEntity<?> saveSession(@RequestBody SessionsEntity session) {
        return ResponseEntity.ok(sessionsService.save(session));
    }

}
