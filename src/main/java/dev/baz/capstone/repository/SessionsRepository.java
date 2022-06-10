package dev.baz.capstone.repository;

import dev.baz.capstone.dto.SessionDTO;
import dev.baz.capstone.entities.SessionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

/**
 * This class is the repository layer for the sessions. It uses JPARepository to access the database.
 * There are automated methods to map the database entities to the entities in the service layer.
 */
@Repository
public interface SessionsRepository extends JpaRepository<SessionsEntity, Integer> {

    List<SessionsEntity> findByInstructorId(int id);

    SessionsEntity save(SessionsEntity session);

    /**
     * This method is used to get the sessions for a specific instructor.
     * A query is used for the database to get the sessions for a specific instructor.
     *
     * @param date the date of the session
     *
     * @return a list of sessions that are on the given date
     */
    @Query("SELECT s FROM SessionsEntity s WHERE s.sessionDate = :date ORDER BY s.sessionTime ASC ")
    List<SessionsEntity> findByDate(LocalDate date);

    /**
     * This method is used to get the sessions for a specific date and time.
     * A query is used for the database to get the sessions for a specific date and time.
     * Duplicates for a specific date and time are not allowed, and the service layer will throw an exception.
     * This is because there can be no overlapping sessions.
     *
     * @param date the date of the session
     * @param time the time of the session
     *
     * @return a list of sessions that are on the given date and time
     */
    @Query("SELECT s FROM SessionsEntity s WHERE s.sessionDate = :date AND s.sessionTime = :time ORDER BY s" +
            ".sessionTime ASC ")
    List<SessionsEntity> findByDateAndTime(LocalDate date, Time time);

    /**
     * This method is used to get all the sessions for a given student.
     * This method returns a list of SessionDTOs that has all the necessary data for the student to see.
     *
     * @param studentId the id of the student
     *
     * @return a list of sessions that the student is enrolled in
     */
    @Query("SELECT new dev.baz.capstone.dto.SessionDTO(s.sessionId, i.instructorId, i.firstName, i.lastName, s" +
            ".sessionName, s.sessionDesc,s.sessionDate,s.sessionTime) FROM InstructorsEntity i JOIN SessionsEntity s " +
            "ON i.instructorId = s.instructorId LEFT JOIN ParticipatesEntity p ON p.sessionId = s.sessionId WHERE p" +
            ".studentId = :studentId AND s.sessionDate >= CURRENT_DATE ORDER BY s.sessionDate " +
            "ASC, s.sessionTime ASC")
    List<SessionDTO> getSessionDetailsByStudent(int studentId);

    /**
     * This method is used to get all the sessions for a given date.
     * This method returns a list of SessionDTOs that has all the necessary data for the student to see.
     *
     * @param date the date of the sessions
     *
     * @return a list of sessions that are on the given date
     */
    @Query("SELECT new dev.baz.capstone.dto.SessionDTO(s.sessionId, i.instructorId, i.firstName, i.lastName, s" +
            ".sessionName, s.sessionDesc,s.sessionDate,s.sessionTime) FROM SessionsEntity s JOIN InstructorsEntity i ON " +
            "s.instructorId = i.instructorId WHERE s.sessionDate = :date ORDER BY s.sessionTime ASC")
    List<SessionDTO> getSessionDetailsByDate(LocalDate date);

}
