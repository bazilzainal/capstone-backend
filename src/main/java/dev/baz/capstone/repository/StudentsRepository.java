package dev.baz.capstone.repository;

import dev.baz.capstone.entities.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class is the repository layer for the students. It uses JPARepository to access the database.
 */
@Repository
public interface StudentsRepository extends JpaRepository<StudentsEntity, Integer> {

    /**
     * This method is used to get a list of students in a particular session.
     *
     * @param id The id of the session
     *
     * @return The students in the given session
     */
    @Query("SELECT s FROM StudentsEntity s LEFT JOIN ParticipatesEntity p ON s.studentId = p.studentId WHERE p.sessionId" +
            " = :id")
    List<StudentsEntity> findStudentsEntitiesBySessionId(int id);

}

