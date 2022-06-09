package dev.baz.capstone.service;

import dev.baz.capstone.dto.SessionDTO;
import dev.baz.capstone.entities.SessionsEntity;
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
        return sessionsRepository.findById(id).orElse(null);
    }

    public List<SessionDTO> getSessionsByDate(LocalDate date) {
        return sessionsRepository.getSessionDetailsByDate(date);
    }

    public List<SessionDTO> getAllStudentSessionDetails(int studentId) {
        return sessionsRepository.getSessionDetailsByStudent(studentId);
    }

}
