package com.pcshop.demo.services;

import com.pcshop.demo.entities.Laptop;
import com.pcshop.demo.repositories.LaptopRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    private final LaptopRepository laptopRepository;

    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
    }
    public void saveAll(List<Laptop> laptops) {
        laptopRepository.saveAll(laptops);
    }

    public List<Laptop> getAll() {
        return laptopRepository.findAll();
    }

    public Optional<Laptop> getById(Long id) {
        return laptopRepository.findById(id);
    }

    public boolean exist(Long id) {
        return laptopRepository.existsById(id);
    }
}
