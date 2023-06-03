package com.pcshop.demo.services;

import com.pcshop.demo.entities.Monitor;
import com.pcshop.demo.repositories.MonitorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class MonitorService {

    MonitorRepository monitorRepository;

    public MonitorService(MonitorRepository monitorRepository) {
        this.monitorRepository = monitorRepository;
    }

    public void save(Monitor monitor) {
        monitorRepository.save(monitor);
    }

    public List<Monitor> getAll() {
        return monitorRepository.findAll();
    }

    public Optional<Monitor> getById(Long id) {
        return monitorRepository.findById(id);
    }

    public boolean exist(Long id) {
        return monitorRepository.existsById(id);
    }
}
