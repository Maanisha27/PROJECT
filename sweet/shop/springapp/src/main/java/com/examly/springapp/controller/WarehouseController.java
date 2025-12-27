package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Warehouse;
import com.examly.springapp.service.WarehouseService;

@RestController
@RequestMapping("/api/warehouses")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<Warehouse> addWarehouse(@RequestBody Warehouse warehouse) {
        return new ResponseEntity<>(warehouseService.addWarehouse(warehouse), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return new ResponseEntity<>(warehouseService.getAllWarehouses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        return new ResponseEntity<>(warehouseService.getWarehouseById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(
            @PathVariable Long id,
            @RequestBody Warehouse warehouse) {

        return new ResponseEntity<>(warehouseService.updateWarehouse(id, warehouse), HttpStatus.OK);
    }
    
    @GetMapping("/location/{location}")
    public ResponseEntity<?> getWarehousesByLocation(@PathVariable String location) {
        List<Warehouse> warehouses = warehouseService.getWarehousesByLocation(location);
        if (warehouses.isEmpty()) {
            return new ResponseEntity<>("No warehouses found at location: " + location, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }
    
    @GetMapping("/location/{location}/name/{name}")
    public ResponseEntity<List<Warehouse>> getWarehousesByLocationAndName(
            @PathVariable String location, 
            @PathVariable String name) {
        List<Warehouse> warehouses = warehouseService.getWarehousesByLocationAndName(location, name);
        return new ResponseEntity<>(warehouses, HttpStatus.OK);
    }
}