package dev.baz.capstone.service;

import dev.baz.capstone.entities.ParticipatesEntity;
import dev.baz.capstone.exception.AlreadyRegisteredException;
import dev.baz.capstone.repository.ParticipatesRepository;
import org.springframework.stereotype.Service;

/**
 * This class is the service layer for the participates. It uses the repository layer to access the database.
 */
@Service
public class ParticipatesService {

    private final ParticipatesRepository participatesRepository;

    public ParticipatesService(ParticipatesRepository participatesRepository) {
        this.participatesRepository = participatesRepository;
    }

    /**
     * This method is used to register a student in a session.
     * It also throws an exception if the student is already registered in the session.
     *
     * @param participates The participating entry to be added to the database.
     *
     * @return The participating entry that was added to the database.
     */
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
