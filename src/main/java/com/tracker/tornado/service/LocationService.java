package com.tracker.tornado.service;

import com.tracker.tornado.model.Location;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LocationService {
    private final Map<Long, Location> locations = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public LocationService() {
        save(new Location(null, "Belgrade", "Serbia", 44.787197, 20.457273));
        save(new Location(null, "Novi Sad", "Serbia", 45.267136, 19.833549));
        save(new Location(null, "Oklahoma City", "USA", 35.467560, -97.516426));
        save(new Location(null, "Joplin", "USA", 37.084229, -94.513283));
    }

    public Collection<Location> findAll() {
        return locations.values();
    }

    public Location findById(Long id) {
        return locations.get(id);
    }

    public Location save(Location location) {
        if (location.getId() == null) {
            location.setId(idCounter.incrementAndGet());
        }
        locations.put(location.getId(), location);
        return location;
    }
}