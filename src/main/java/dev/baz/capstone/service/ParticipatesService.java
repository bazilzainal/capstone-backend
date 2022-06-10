package dev.baz.capstone.service;

import dev.baz.capstone.entities.ParticipatesEntity;
import dev.baz.capstone.exception.AlreadyRegisteredException;
import dev.baz.capstone.repository.ParticipatesRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipatesService {

    private final ParticipatesRepository participatesRepository;

    public ParticipatesService(ParticipatesRepository participatesRepository) {
        this.participatesRepository = participatesRepository;
    }

    public ParticipatesEntity save(ParticipatesEntity participates) {
        // Check if entry exists in the participates table
        ParticipatesEntity existingParticipates = getParticipatesByStudentIdAndSessionId(participates.getStudentId(), participates.getSessionId());

        if (existingParticipates != null) {
            throw new AlreadyRegisteredException();
        }

        return participatesRepository.save(participates);
    }

    public ParticipatesEntity getParticipatesByStudentIdAndSessionId(int studentId, int sessionId) {

        return participatesRepository.findByStudentIdAndSessionId(studentId, sessionId);
    }
}
