package dev.baz.capstone.repository;

import dev.baz.capstone.entities.ParticipatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This class is the repository layer for the participates. It uses JPARepository to access the database.
 * There are automated methods to map the database entities to the entities in the service layer.
 */
@Repository
public interface ParticipatesRepository extends JpaRepository<ParticipatesEntity, Integer> {

    ParticipatesEntity findByStudentIdAndSessionId(int studentId, int sessionId);
}

