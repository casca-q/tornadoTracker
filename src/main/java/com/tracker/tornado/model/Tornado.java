package com.tracker.tornado.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

public class Tornado {
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;

    private Long locationId;
    private FujitaScale fujitaScale;
    private String damageDescription;

    public Tornado() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
    public Long getLocationId() { return locationId; }
    public void setLocationId(Long locationId) { this.locationId = locationId; }
    public FujitaScale getFujitaScale() { return fujitaScale; }
    public void setFujitaScale(FujitaScale fujitaScale) { this.fujitaScale = fujitaScale; }
    public String getDamageDescription() { return damageDescription; }
    public void setDamageDescription(String damageDescription) { this.damageDescription = damageDescription; }
}