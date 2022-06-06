package dev.baz.capstone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
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
    @Column(name = "date", nullable = false)
    private Date date;

    @Basic
    @Column(name = "time", nullable = false)
    private Time time;

    @Basic
    @Column(name = "desc", nullable = true, length = -1)
    private String desc;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id", nullable = false, insertable = false,
            updatable = false)
    @JsonIgnore
    private InstructorsEntity instructorsByInstructorId;

    @OneToMany(mappedBy = "sessionsBySessionId")
    @JsonManagedReference
    private List<ParticipatesEntity> participatesBySessionId;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionsEntity that = (SessionsEntity) o;

        if (sessionId != that.sessionId) return false;
        if (instructorId != that.instructorId) return false;
        if (sessionName != null ? !sessionName.equals(that.sessionName) : that.sessionName != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionId;
        result = 31 * result + instructorId;
        result = 31 * result + (sessionName != null ? sessionName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    public InstructorsEntity getInstructorsByInstructorId() {
        return instructorsByInstructorId;
    }

    public void setInstructorsByInstructorId(InstructorsEntity instructorsByInstructorId) {
        this.instructorsByInstructorId = instructorsByInstructorId;
    }
}
