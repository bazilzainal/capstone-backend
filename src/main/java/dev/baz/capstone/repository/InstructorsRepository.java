package dev.baz.capstone.repository;

import dev.baz.capstone.entities.InstructorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is the repository layer for the instructors. It uses JPARepository to access the database.
 * The service layer uses automapping to map the database entities to the entities in the service layer.
 *
 */
@Repository
public interface InstructorsRepository extends JpaRepository<InstructorsEntity, Integer> {


}
