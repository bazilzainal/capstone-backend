package dev.baz.capstone.repository;

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

}
