package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.VehicleDAO;
import com.pluralsight.dealership.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiclesController {
    private VehicleDAO vehicleDAO;

    @Autowired
    public VehiclesController(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }
    @PostMapping("/add") //adds a new car to database
    public Vehicle addVehicle(@RequestBody Vehicle vehicle){
        return vehicleDAO.addVehicle(vehicle);
    }

    @DeleteMapping("/delete/{vin}") //deletes the car from database
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable int vin){
        vehicleDAO.deleteVehicle(vin);
    }
    @GetMapping("/byPriceRange")
    public List<Vehicle> getByPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice){
        return vehicleDAO.byPriceRange(minPrice,maxPrice);
    }
    @GetMapping("/byMake")
    public List<Vehicle> getByMake(
            @RequestParam String make){
        return vehicleDAO.getByMake(make);
    }
    @GetMapping("/byModel")
    public List<Vehicle> getByModel(
            @RequestParam String model){
        return vehicleDAO.getByModel(model);
    }
    @GetMapping("/byYearRange")
    public List<Vehicle> getByYearRange(
            @RequestParam int minYear,
            @RequestParam int maxYear){
        return vehicleDAO.byYearRange(minYear,maxYear);
    }
    @GetMapping("/byColor")
    public List<Vehicle> getByColor(
            @RequestParam String color){
        return vehicleDAO.getByColor(color);
    }
    @GetMapping("/byMileageRange")
    public List<Vehicle> getByMileageRange(
            @RequestParam int minRange,
            @RequestParam int maxRange){
        return vehicleDAO.getByMileageRange(minRange,maxRange);
    }
    @GetMapping("/byType")
    public List<Vehicle> getByType(
            @RequestParam String type){
        return vehicleDAO.getByType(type);
    }


}
