package dev.baz.capstone.service;

import dev.baz.capstone.dto.SessionDTO;
import dev.baz.capstone.entities.SessionsEntity;
import dev.baz.capstone.exception.NoSessionForDateException;
import dev.baz.capstone.exception.NoSessionForIdException;
import dev.baz.capstone.repository.SessionsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public SessionsEntity save(SessionsEntity session) {
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

        return sessionsRepository.getSessionDetailsByDate(date);
    }

    public List<SessionDTO> getAllStudentSessionDetails(int studentId) {
        return sessionsRepository.getSessionDetailsByStudent(studentId);
    }

}
