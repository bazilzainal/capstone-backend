package dev.baz.capstone.service;

import dev.baz.capstone.entities.InstructorsEntity;
import dev.baz.capstone.repository.InstructorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class is the service layer for the instructors. It uses JPARepository to access the database.
 * All the methods here are called by the controller.
 */
@Service
public class InstructorsService {

    private final InstructorsRepository instructorsRepository;

    public InstructorsService(InstructorsRepository instructorsRepository) {
        this.instructorsRepository = instructorsRepository;
    }

    public InstructorsEntity getInstructor(int id) {
        return instructorsRepository.findById(id).orElse(null);
    }

    public List<InstructorsEntity> getInstructors() {
        return instructorsRepository.findAll();
    }
}
