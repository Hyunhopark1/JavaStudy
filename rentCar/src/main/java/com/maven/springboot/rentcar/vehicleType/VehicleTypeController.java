package com.maven.springboot.rentcar.vehicleType;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vt")
public class VehicleTypeController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleTypeController.class);

    @Autowired
    private IVehicleTypeService vehicleTypeService;

    @PostMapping
    public ResponseEntity<IVehicleType> insert(@RequestBody VehicleTypeDto dto) {
        try {
            if (dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IVehicleType result = this.vehicleTypeService.insert(dto);
            if (result == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<IVehicleType>> getAll() {
        try {
            List<IVehicleType> result = this.vehicleTypeService.getAllList();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        try {
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            Boolean result = this.vehicleTypeService.delete(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<IVehicleType> update(@PathVariable Long id, VehicleTypeDto dto) {
        try {
            if (id == null || dto == null) {
                return ResponseEntity.badRequest().build();
            }
            IVehicleType result = this.vehicleTypeService.update(id, dto);
            if (result == null) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error(e.toString());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<IVehicleType> findById(@PathVariable Long id) {
        try {
            if (id == null || id <= 0) {
                return ResponseEntity.badRequest().build();
            }
            IVehicleType result = this.vehicleTypeService.findById(id);
            if (result == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/nm/{name}")
    public ResponseEntity<List<IVehicleType>> findAllByNameContains(@PathVariable String name) {
        try {
            if (name == null || name.isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            List<IVehicleType> result = vehicleTypeService.findAllByNameContains(name);
            if (result == null || result.size() <= 0) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return ResponseEntity.badRequest().build();
        }
    }
}
