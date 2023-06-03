package com.pcshop.demo.controllers;

import com.pcshop.demo.entities.DesktopComputer;
import com.pcshop.demo.entities.Hdd;
import com.pcshop.demo.entities.Laptop;
import com.pcshop.demo.entities.Monitor;
import com.pcshop.demo.productEnum.Products;
import com.pcshop.demo.request.EntityRequest;
import com.pcshop.demo.response.EntityResponse;
import com.pcshop.demo.services.DesktopComputerService;
import com.pcshop.demo.services.HddService;
import com.pcshop.demo.services.LaptopService;
import com.pcshop.demo.services.MonitorService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @Autowired
    DesktopComputerService desktopComputerService;
    @Autowired
    HddService hddService;
    @Autowired
    MonitorService monitorService;
    @Autowired
    LaptopService laptopService;

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addType(@RequestBody EntityRequest request) {
        switch (Products.valueOf(request.getType().toUpperCase())) {
            case DESKTOP_COMPUTER:
                DesktopComputer desktopPc = new DesktopComputer();
                desktopPc.setPrice(request.getPrice());
                desktopPc.setForm(request.getForm());
                desktopPc.setSeries(request.getSeries());
                desktopPc.setQuantity(request.getQuantity());
                desktopPc.setManufacturer(request.getManufacturer());
                desktopComputerService.save(desktopPc);
                break;
            case HDD:
                Hdd hdd = new Hdd();
                hdd.setPrice(request.getPrice());
                hdd.setVolume(request.getVolume());
                hdd.setSeries(request.getSeries());
                hdd.setQuantity(request.getQuantity());
                hdd.setManufacturer(request.getManufacturer());
                hddService.save(hdd);
                break;
            case LAPTOP:
                Laptop laptop = new Laptop();
                laptop.setPrice(request.getPrice());
                laptop.setSize(request.getSize());
                laptop.setSeries(request.getSeries());
                laptop.setQuantity(request.getQuantity());
                laptop.setManufacturer(request.getManufacturer());
                laptopService.save(laptop);
                break;
            case MONITOR:
                Monitor monitor = new Monitor();
                monitor.setPrice(request.getPrice());
                monitor.setDiagonal(request.getDiagonal());
                monitor.setSeries(request.getSeries());
                monitor.setQuantity(request.getQuantity());
                monitor.setManufacturer(request.getManufacturer());
                monitorService.save(monitor);
                break;
        }
    }

    @GetMapping(value = "/get/{type}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntityResponse getProduct(@PathVariable(name = "type") String type, @PathVariable(name = "id") Long id) {
        switch (Products.valueOf(type.toUpperCase())) {
            case DESKTOP_COMPUTER:
                Optional<DesktopComputer> pc = desktopComputerService.getById(id);
                if (pc.isPresent()) {
                    EntityResponse<DesktopComputer> response = new EntityResponse();
                    response.setType(Products.DESKTOP_COMPUTER.value);
                    response.setProductsForType(List.of(pc.get()));
                    response.setCount(response.getProductsForType().size());
                    return response;
                } else {
                    throw new NoSuchElementException("Не найдено товара с данным ID");
                }
            case HDD:
                Optional<Hdd> hdd = hddService.getById(id);
                if (hdd.isPresent()) {
                    EntityResponse<Hdd> response = new EntityResponse();
                    response.setType(Products.HDD.value);
                    response.setProductsForType(List.of(hdd.get()));
                    response.setCount(response.getProductsForType().size());
                    return response;
                } else {
                    throw new NoSuchElementException("Не найдено товара с данным ID");
                }
            case LAPTOP:
                Optional<Laptop> laptop = laptopService.getById(id);
                if (laptop.isPresent()) {
                    EntityResponse<Laptop> response = new EntityResponse();
                    response.setType(Products.LAPTOP.value);
                    response.setProductsForType(List.of(laptop.get()));
                    response.setCount(response.getProductsForType().size());
                    return response;
                } else {
                    throw new NoSuchElementException("Не найдено товара с данным ID");
                }
            case MONITOR:
                Optional<Monitor> monitor = monitorService.getById(id);
                if (monitor.isPresent()) {
                    EntityResponse<Monitor> response = new EntityResponse();
                    response.setType(Products.MONITOR.value);
                    response.setProductsForType(List.of(monitor.get()));
                    response.setCount(response.getProductsForType().size());
                    return response;
                } else {
                    throw new NoSuchElementException("Не найдено товара с данным ID");
                }
            default:
                throw new NoSuchElementException("Не определен тип товара");
        }
    }

    @GetMapping(value = "/get/all/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EntityResponse getAllProducts(@PathVariable(name = "type") String type) {
        switch (Products.valueOf(type.toUpperCase())) {
            case DESKTOP_COMPUTER:
                List<DesktopComputer> pc = desktopComputerService.getAll();
                if (!pc.isEmpty()) {
                    EntityResponse<DesktopComputer> response = new EntityResponse<>();
                    response.setType(Products.DESKTOP_COMPUTER.value);
                    response.setProductsForType(pc);
                    response.setCount(response.getProductsForType().size());
                    return response;
                } else {
                    throw new NoSuchElementException("Не найдено товара с данным ID");
                }
            case HDD:
                List<Hdd> hdd = hddService.getAll();
                if (!hdd.isEmpty()) {
                    EntityResponse<Hdd> response = new EntityResponse();
                    response.setType(Products.HDD.value);
                    response.setProductsForType(hdd);
                    response.setCount(response.getProductsForType().size());
                    return response;
                } else {
                    throw new NoSuchElementException("Не найдено товара с данным ID");
                }
            case LAPTOP:
                List<Laptop> laptop = laptopService.getAll();
                if (!laptop.isEmpty()) {
                    EntityResponse<Laptop> response = new EntityResponse();
                    response.setType(Products.LAPTOP.value);
                    response.setProductsForType(laptop);
                    response.setCount(response.getProductsForType().size());
                    return response;
                } else {
                    throw new NoSuchElementException("Не найдено товара с данным ID");
                }
            case MONITOR:
                List<Monitor> monitor = monitorService.getAll();
                if (!monitor.isEmpty()) {
                    EntityResponse<Monitor> response = new EntityResponse();
                    response.setType(Products.MONITOR.value);
                    response.setProductsForType(monitor);
                    response.setCount(response.getProductsForType().size());
                    return response;
                } else {
                    throw new NoSuchElementException("Не найдено товара с данным ID");
                }
            default:
                throw new NoSuchElementException("Не определен тип товара");
        }
    }

    @PostMapping(value = "/edit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void editProduct(@RequestBody EntityRequest request) {
        switch (Products.valueOf(request.getType().toUpperCase())) {
            case DESKTOP_COMPUTER:
                Optional<DesktopComputer> desktopPc = desktopComputerService.getById(request.getId());
                if (desktopPc.isPresent()) {
                    desktopPc.get().setPrice(request.getPrice());
                    desktopPc.get().setForm(request.getForm());
                    desktopPc.get().setSeries(request.getSeries());
                    desktopPc.get().setQuantity(request.getQuantity());
                    desktopPc.get().setManufacturer(request.getManufacturer());

                    desktopComputerService.save(desktopPc.get());
                } else {
                    throw new NoSuchElementException("Продукт не найден в БД");
                }
                break;
            case HDD:
                Optional<Hdd> hdd = hddService.getById(request.getId());
                if (hdd.isPresent()) {
                    hdd.get().setPrice(request.getPrice());
                    hdd.get().setVolume(request.getVolume());
                    hdd.get().setSeries(request.getSeries());
                    hdd.get().setQuantity(request.getQuantity());
                    hdd.get().setManufacturer(request.getManufacturer());

                    hddService.save(hdd.get());
                } else {
                    throw new NoSuchElementException("Продукт не найден в БД");
                }
                break;
            case LAPTOP:
                Optional<Laptop> laptop = laptopService.getById(request.getId());
                if (laptop.isPresent()) {
                    laptop.get().setPrice(request.getPrice());
                    laptop.get().setSize(request.getSize());
                    laptop.get().setSeries(request.getSeries());
                    laptop.get().setQuantity(request.getQuantity());
                    laptop.get().setManufacturer(request.getManufacturer());

                    laptopService.save(laptop.get());
                } else {
                    throw new NoSuchElementException("Продукт не найден в БД");
                }
                break;
            case MONITOR:
                Optional<Monitor> monitor = monitorService.getById(request.getId());
                if (monitor.isPresent()) {
                    monitor.get().setPrice(request.getPrice());
                    monitor.get().setDiagonal(request.getDiagonal());
                    monitor.get().setSeries(request.getSeries());
                    monitor.get().setQuantity(request.getQuantity());
                    monitor.get().setManufacturer(request.getManufacturer());

                    monitorService.save(monitor.get());
                } else {
                    throw new NoSuchElementException("Продукт не найден в БД");
                }
                break;
            default:
                throw new NoSuchElementException("Не определен тип продукта");
        }
    }
}
