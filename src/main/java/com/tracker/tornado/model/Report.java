package com.tracker.tornado.model;

import java.time.LocalDateTime;

public class Report {
    private Long id;
    private Long tornadoId;
    private String reportSource;
    private LocalDateTime reportTime;
    private String status;

    public Report() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTornadoId() { return tornadoId; }
    public void setTornadoId(Long tornadoId) { this.tornadoId = tornadoId; }
    public String getReportSource() { return reportSource; }
    public void setReportSource(String reportSource) { this.reportSource = reportSource; }
    public LocalDateTime getReportTime() { return reportTime; }
    public void setReportTime(LocalDateTime reportTime) { this.reportTime = reportTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}