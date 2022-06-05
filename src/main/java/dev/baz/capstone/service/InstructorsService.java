package dev.baz.capstone.service;

import dev.baz.capstone.entities.InstructorsEntity;
import dev.baz.capstone.repository.InstructorsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
