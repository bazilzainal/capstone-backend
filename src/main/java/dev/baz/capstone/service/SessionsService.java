package dev.baz.capstone.service;

import dev.baz.capstone.entities.SessionsEntity;
import dev.baz.capstone.repository.SessionsRepository;
import org.springframework.stereotype.Service;

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

    public List<SessionsEntity> getSessionByInstructor(int id) {
        return sessionsRepository.findByInstructorId(id);
    }

    public SessionsEntity save(SessionsEntity session) {
        return sessionsRepository.save(session);
    }
}
