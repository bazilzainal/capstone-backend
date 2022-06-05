package dev.baz.capstone.service;

import dev.baz.capstone.entities.StudentsEntity;
import dev.baz.capstone.repository.StudentsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
