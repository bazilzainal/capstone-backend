package dev.baz.capstone.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class ParticipatesEntityPK implements Serializable {
    @Column(name = "student_id", nullable = false)
    @Id
    private int studentId;

    @Column(name = "session_id", nullable = false)
    @Id
    private int sessionId;

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

        ParticipatesEntityPK that = (ParticipatesEntityPK) o;

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
}
