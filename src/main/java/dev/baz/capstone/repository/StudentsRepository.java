package dev.baz.capstone.repository;

import dev.baz.capstone.entities.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<StudentsEntity, Integer> {

    @Query("SELECT s FROM StudentsEntity s LEFT JOIN ParticipatesEntity p ON s.studentId = p.studentId WHERE p.sessionId" +
            " = :id")
    List<StudentsEntity> findStudentsEntitiesBySessionId(int id);

}

