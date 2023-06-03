package com.pcshop.demo.services;

import com.pcshop.demo.entities.DesktopComputer;
import com.pcshop.demo.repositories.DesktopComputerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DesktopComputerService {

    private final DesktopComputerRepository desktopComputerRepository;

    public DesktopComputerService(DesktopComputerRepository desktopComputerRepository) {
        this.desktopComputerRepository = desktopComputerRepository;
    }

    public void save(DesktopComputer desktopComputer) {
        desktopComputerRepository.save(desktopComputer);
    }
    public void saveAll(List<DesktopComputer> desktopComputers) {
        desktopComputerRepository.saveAll(desktopComputers);
    }

    public List<DesktopComputer> getAll() {
        return desktopComputerRepository.findAll();
    }

    public Optional<DesktopComputer> getById(Long id) {
        return desktopComputerRepository.findById(id);
    }

    public boolean exist(Long id) {
        return desktopComputerRepository.existsById(id);
    }
}
