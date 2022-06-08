package dev.baz.capstone.service;

import dev.baz.capstone.entities.ParticipatesEntity;
import dev.baz.capstone.repository.ParticipatesRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipatesService {

    private final ParticipatesRepository participatesRepository;

    public ParticipatesService(ParticipatesRepository participatesRepository) {
        this.participatesRepository = participatesRepository;
    }

    public ParticipatesEntity save(ParticipatesEntity participates) {
        return participatesRepository.save(participates);
    }

    public ParticipatesEntity getParticipatesByStudentIdAndSessionId(int studentId, int sessionId) {
        return participatesRepository.findByStudentIdAndSessionId(studentId, sessionId);
    }
}
