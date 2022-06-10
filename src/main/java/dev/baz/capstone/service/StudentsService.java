package dev.baz.capstone.service;

import dev.baz.capstone.entities.StudentsEntity;
import dev.baz.capstone.repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is the service layer for the students. It uses JPARepository to access the database.
 */
@Service
public class StudentsService {

    private final StudentsRepository studentsRepository;

    public StudentsService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<StudentsEntity> getStudents() {
        return studentsRepository.findAll();
    }

    public List<StudentsEntity> getStudentsBySession(int id) {
        return studentsRepository.findStudentsEntitiesBySessionId(id);
    }

    public StudentsEntity getStudentDetails(int id) {
        return studentsRepository.findById(id).orElse(null);
    }
}
