package com.tracker.tornado.service;

import com.tracker.tornado.model.Tornado;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TornadoService {
    private final Map<Long, Tornado> tornadoes = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Tornado> findAll() {
        return new ArrayList<>(tornadoes.values());
    }

    public Tornado findById(Long id) {
        return tornadoes.get(id);
    }

    public Tornado save(Tornado tornado) {
        if (tornado.getId() == null) {
            tornado.setId(idCounter.incrementAndGet());
        }
        tornadoes.put(tornado.getId(), tornado);
        return tornado;
    }

    public void deleteById(Long id) {
        tornadoes.remove(id);
    }
}