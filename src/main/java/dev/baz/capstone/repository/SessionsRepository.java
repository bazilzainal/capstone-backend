package dev.baz.capstone.repository;

import dev.baz.capstone.dto.SessionDTO;
import dev.baz.capstone.entities.SessionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SessionsRepository extends JpaRepository<SessionsEntity, Integer> {

    List<SessionsEntity> findByInstructorId(int id);

    SessionsEntity save(SessionsEntity session);

    @Query("SELECT s FROM SessionsEntity s WHERE s.sessionDate = :date ORDER BY s.sessionTime ASC ")
    List<SessionsEntity> findByDate(LocalDate date);

    @Query("SELECT s FROM SessionsEntity s WHERE s.sessionDate = :date AND s.sessionTime = :time ORDER BY s" +
            ".sessionTime ASC ")
    List<SessionsEntity> findByDateAndTime(LocalDate date, Time time);

    // Only return sessions after the current date
    @Query("SELECT new dev.baz.capstone.dto.SessionDTO(s.sessionId, i.instructorId, i.firstName, i.lastName, s" +
            ".sessionName, s.sessionDesc,s.sessionDate,s.sessionTime) FROM InstructorsEntity i JOIN SessionsEntity s " +
            "ON i.instructorId = s.instructorId LEFT JOIN ParticipatesEntity p ON p.sessionId = s.sessionId WHERE p" +
            ".studentId = :studentId AND s.sessionDate >= CURRENT_DATE ORDER BY s.sessionDate " +
            "ASC, s.sessionTime ASC")
    List<SessionDTO> getSessionDetailsByStudent(int studentId);

    @Query("SELECT new dev.baz.capstone.dto.SessionDTO(s.sessionId, i.instructorId, i.firstName, i.lastName, s" +
            ".sessionName, s.sessionDesc,s.sessionDate,s.sessionTime) FROM SessionsEntity s JOIN InstructorsEntity i ON " +
            "s.instructorId = i.instructorId WHERE s.sessionDate = :date ORDER BY s.sessionTime ASC")
    List<SessionDTO> getSessionDetailsByDate(LocalDate date);

}
