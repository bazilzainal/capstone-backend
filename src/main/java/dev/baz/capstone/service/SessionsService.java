package dev.baz.capstone.service;

import dev.baz.capstone.dto.SessionDTO;
import dev.baz.capstone.entities.SessionsEntity;
import dev.baz.capstone.exception.NoSessionForDateException;
import dev.baz.capstone.exception.NoSessionForIdException;
import dev.baz.capstone.exception.SessionDuplicateException;
import dev.baz.capstone.repository.SessionsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * This class is the service layer for the sessions. It uses JPARepository to access the database.
 */
@Service
public class SessionsService {

    private final SessionsRepository sessionsRepository;

    public SessionsService(SessionsRepository sessionsRepository) {
        this.sessionsRepository = sessionsRepository;
    }

    public List<SessionsEntity> getSessions() {
        return sessionsRepository.findAll();
    }

    public List<SessionsEntity> getSessionsByInstructor(int id) {
        return sessionsRepository.findByInstructorId(id);
    }

    /**
     * This method saves a session to the database.
     * It also throws an exception if a session of the same date and time is already in the database.
     * This is because no overlapping sessions are allowed.
     *
     * @param session The session to be added to the database.
     *
     * @return The session that was added to the database.
     */
    public SessionsEntity save(SessionsEntity session) {
        if (!sessionsRepository.findByDateAndTime(session.getSessionDate(), session.getSessionTime()).isEmpty()) {
            throw new SessionDuplicateException();
        }

        return sessionsRepository.save(session);
    }

    public SessionsEntity getSessionDetails(Integer id) {
        if (sessionsRepository.findById(id).isPresent()) {
            return sessionsRepository.findById(id).get();
        } else {
            throw new NoSessionForIdException();
        }
    }

    public List<SessionDTO> getSessionsByDate(LocalDate date) {
        List<SessionDTO> sessions = sessionsRepository.getSessionDetailsByDate(date);

        if (sessions.isEmpty()) {
            throw new NoSessionForDateException();
        }

        return sessions;
    }

    public List<SessionDTO> getAllStudentSessionDetails(int studentId) {
        return sessionsRepository.getSessionDetailsByStudent(studentId);
    }

}
