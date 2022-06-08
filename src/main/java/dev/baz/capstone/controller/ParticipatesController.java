package dev.baz.capstone.controller;

import dev.baz.capstone.entities.ParticipatesEntity;
import dev.baz.capstone.service.ParticipatesService;
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
    public ResponseEntity<ParticipatesEntity> saveParticipates(@RequestBody ParticipatesEntity participates) {
        return ResponseEntity.ok(participatesService.save(participates));
    }

}
