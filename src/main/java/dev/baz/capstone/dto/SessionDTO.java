package dev.baz.capstone.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

/**
 * This DTO is used to represent a session.
 * It helps to parse the session data from the database to the frontend.
 */
public class SessionDTO {
    private int sessionId;

    private int instructorId;

    private String instructorFirstName;

    private String instructorLastName;

    private String sessionName;

    private String sessionDescription;

    private LocalDate sessionDate;

    private Date sessionTime;

    public SessionDTO() {
    }

    public SessionDTO(int sessionId, int instructorId, String instructorFirstName, String instructorLastName,
                      String sessionName, String sessionDescription, LocalDate sessionDate, Date sessionTime) {
        this.sessionId = sessionId;
        this.instructorId = instructorId;
        this.instructorFirstName = instructorFirstName;
        this.instructorLastName = instructorLastName;
        this.sessionName = sessionName;
        this.sessionDescription = sessionDescription;
        this.sessionDate = sessionDate;
        this.sessionTime = sessionTime;
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

    public String getInstructorFirstName() {
        return instructorFirstName;
    }

    public void setInstructorFirstName(String instructorFirstName) {
        this.instructorFirstName = instructorFirstName;
    }

    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {
        this.instructorLastName = instructorLastName;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public Date getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(Date sessionTime) {
        this.sessionTime = sessionTime;
    }
}
