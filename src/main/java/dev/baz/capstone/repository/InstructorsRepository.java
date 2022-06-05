package dev.baz.capstone.repository;

import dev.baz.capstone.entities.InstructorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorsRepository extends JpaRepository<InstructorsEntity, Integer> {


}
