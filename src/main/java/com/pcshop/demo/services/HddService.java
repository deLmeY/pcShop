package com.pcshop.demo.services;

import com.pcshop.demo.entities.Hdd;
import com.pcshop.demo.repositories.HddRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class HddService {
    private final HddRepository hddRepository;

    public HddService(HddRepository hddRepository) {
        this.hddRepository = hddRepository;
    }

    public void save(Hdd hdd) {
        hddRepository.save(hdd);
    }

    public void saveAll(List<Hdd> hdds) {
        hddRepository.saveAll(hdds);
    }

    public List<Hdd> getAll() {
        return hddRepository.findAll();
    }

    public Optional<Hdd> getById(Long id) {
        return hddRepository.findById(id);
    }

    public boolean exist(Long id) {
        return hddRepository.existsById(id);
    }
}
