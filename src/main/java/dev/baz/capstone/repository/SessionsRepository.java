package dev.baz.capstone.repository;

import dev.baz.capstone.entities.SessionsEntity;
import dev.baz.capstone.entities.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionsRepository extends JpaRepository<SessionsEntity, Integer> {

    List<SessionsEntity> findByInstructorId(int id);

    SessionsEntity save(SessionsEntity session);

}
