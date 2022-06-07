package dev.baz.capstone.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sessions", schema = "capstone")
public class SessionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "session_id", nullable = false)
    private int sessionId;

    @Basic
    @Column(name = "instructor_id", nullable = false)
    private int instructorId;

    @Basic
    @Column(name = "session_name", nullable = false, length = 100)
    private String sessionName;

    @Basic
    @Column(name = "session_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate sessionDate;

    @Basic
    @Column(name = "session_time", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private Time sessionTime;

    @Basic
    @Column(name = "session_desc", nullable = true, length = -1)
    private String sessionDesc;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id", nullable = false, insertable = false,
            updatable = false)
    @JsonIgnore
    private InstructorsEntity instructorsByInstructorId;

    @OneToMany(mappedBy = "sessionsBySessionId")
    @JsonManagedReference(value="sessionsBySessionId")
    private List<ParticipatesEntity> participatesBySessionId;

    public SessionsEntity() {
    }

    public SessionsEntity(int instructorId, String sessionName, LocalDate sessionDate, Time time, String sessionDesc) {
        this.instructorId = instructorId;
        this.sessionName = sessionName;
        this.sessionDate = sessionDate;
        this.sessionTime = time;
        this.sessionDesc = sessionDesc;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate date) {
        this.sessionDate = date;
    }

    public Time getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Time time) {
        this.sessionTime = time;
    }

    public String getSessionDesc() {
        return sessionDesc;
    }

    public void setSessionDesc(String desc) {
        this.sessionDesc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionsEntity that = (SessionsEntity) o;

        if (sessionId != that.sessionId) return false;
        if (instructorId != that.instructorId) return false;
        if (sessionName != null ? !sessionName.equals(that.sessionName) : that.sessionName != null) return false;
        if (sessionDate != null ? !sessionDate.equals(that.sessionDate) : that.sessionDate != null) return false;
        if (sessionTime != null ? !sessionTime.equals(that.sessionTime) : that.sessionTime != null) return false;
        if (sessionDesc != null ? !sessionDesc.equals(that.sessionDesc) : that.sessionDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + instructorId;
        result = 31 * result + (sessionName != null ? sessionName.hashCode() : 0);
        result = 31 * result + (sessionDate != null ? sessionDate.hashCode() : 0);
        result = 31 * result + (sessionTime != null ? sessionTime.hashCode() : 0);
        result = 31 * result + (sessionDesc != null ? sessionDesc.hashCode() : 0);
        return result;
    }

    public InstructorsEntity getInstructorsByInstructorId() {
        return instructorsByInstructorId;
    }

    public void setInstructorsByInstructorId(InstructorsEntity instructorsByInstructorId) {
        this.instructorsByInstructorId = instructorsByInstructorId;
    }
}
