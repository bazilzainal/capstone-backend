package dev.baz.capstone.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "participates", schema = "capstone")
@IdClass(ParticipatesEntityPK.class)
public class ParticipatesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id", nullable = false)
    private int studentId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "session_id", nullable = false)
    private int sessionId;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference(value = "studentsByStudentId")
    private StudentsEntity studentsByStudentId;

    @ManyToOne
    @JoinColumn(name = "session_id", referencedColumnName = "session_id", nullable = false, insertable = false, updatable = false)
    @JsonBackReference(value="sessionsBySessionId")
    private SessionsEntity sessionsBySessionId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipatesEntity that = (ParticipatesEntity) o;

        if (studentId != that.studentId) return false;
        if (sessionId != that.sessionId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + sessionId;
        return result;
    }

    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    public SessionsEntity getSessionsBySessionId() {
        return sessionsBySessionId;
    }

    public void setSessionsBySessionId(SessionsEntity sessionsBySessionId) {
        this.sessionsBySessionId = sessionsBySessionId;
    }
}
