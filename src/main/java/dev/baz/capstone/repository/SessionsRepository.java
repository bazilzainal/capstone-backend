package dev.baz.capstone.repository;

import dev.baz.capstone.dto.SessionDTO;
import dev.baz.capstone.entities.SessionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SessionsRepository extends JpaRepository<SessionsEntity, Integer> {

    List<SessionsEntity> findByInstructorId(int id);

    SessionsEntity save(SessionsEntity session);

    @Query("SELECT s FROM SessionsEntity s WHERE s.sessionDate = :date")
    List<SessionsEntity> findByDate(LocalDate date);

    @Query("SELECT new dev.baz.capstone.dto.SessionDTO(s.sessionId, i.instructorId, i.firstName, i.lastName, s" +
            ".sessionName, s.sessionDesc,s.sessionDate,s.sessionTime) FROM InstructorsEntity i JOIN SessionsEntity s " +
            "ON i.instructorId = s.instructorId LEFT JOIN ParticipatesEntity p ON p.sessionId = s.sessionId WHERE p.studentId = :studentId")
    List<SessionDTO> getAllStudentSessionDetails(int studentId);

}
