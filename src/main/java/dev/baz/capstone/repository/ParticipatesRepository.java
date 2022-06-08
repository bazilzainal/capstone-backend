package dev.baz.capstone.repository;

import dev.baz.capstone.entities.ParticipatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipatesRepository extends JpaRepository<ParticipatesEntity, Integer> {

    ParticipatesEntity findByStudentIdAndSessionId(int studentId, int sessionId);
}

