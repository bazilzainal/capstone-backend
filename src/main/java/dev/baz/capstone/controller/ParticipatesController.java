package dev.baz.capstone.controller;

import dev.baz.capstone.entities.ParticipatesEntity;
import dev.baz.capstone.service.ParticipatesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ParticipatesController {

    private final ParticipatesService participatesService;

    public ParticipatesController(ParticipatesService participatesService) {
        this.participatesService = participatesService;
    }

    @PostMapping("/participates")
    public ResponseEntity<?> saveParticipates(@RequestBody ParticipatesEntity participates) {

        // Check if entry exists in the participates table
        ParticipatesEntity existingParticipates = participatesService.getParticipatesByStudentIdAndSessionId(participates.getStudentId(), participates.getSessionId());

        if (existingParticipates != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student already registered for this session");
        }
        return ResponseEntity.ok(participatesService.save(participates));
    }

}
