package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class VehicleDAO {
    static DataSource dataSource;

    @Autowired
    public VehicleDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        String vehicleType = vehicle.getVehicleType();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pStmt = conn.prepareStatement
                     ("INSERT INTO Vehicles(vin,year,make,model,type,color,mileage,price,sold,lease) VALUES (?,?,?,?,?,?,?,?,?,?)")) {
            pStmt.setInt(1, vehicle.getVin());
            pStmt.setInt(2, vehicle.getYear());
            pStmt.setString(3, vehicle.getMake());
            pStmt.setString(4, vehicle.getModel());
            pStmt.setString(5, (vehicleType != null) ? vehicleType : "Unknown");
            pStmt.setString(6, vehicle.getColor());
            pStmt.setInt(7, vehicle.getOdometer());
            pStmt.setDouble(8, vehicle.getPrice());
            pStmt.setBoolean(9, vehicle.isSold());
            pStmt.setBoolean(10, vehicle.isLeased());
            int rows = pStmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Vehicle has been added.");
                return vehicle;
            } else {
                System.out.println("Something went wrong, failed to add.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicle;
    }
    public List<Vehicle> byPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement queryEx = conn.prepareStatement("SELECT * FROM Vehicles WHERE price BETWEEN ? AND ?")) {
            queryEx.setDouble(1, minPrice);
            queryEx.setDouble(2, maxPrice);
            try (ResultSet rows = queryEx.executeQuery()) {
                while (rows.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVin(rows.getInt("vin"));
                    vehicle.setMake(rows.getString("make"));
                    vehicle.setModel(rows.getString("model"));
                    vehicle.setPrice(rows.getDouble("price"));
                    vehicles.add(vehicle);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
    public List<Vehicle> getByMake(String make) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement queryEx = conn.prepareStatement("SELECT * FROM Vehicles WHERE make = ?")) {
            queryEx.setString(1, make);
            ResultSet rows = queryEx.executeQuery();
            if (rows.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(rows.getInt("vin"));
                vehicle.setMake(rows.getString("make"));
                vehicle.setModel(rows.getString("model"));
                vehicle.setPrice(rows.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public List<Vehicle> getByModel(String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement queryEx = conn.prepareStatement("SELECT * FROM Vehicles WHERE model = ?")) {
            queryEx.setString(1, model);
            ResultSet rows = queryEx.executeQuery();
            if (rows.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(rows.getInt("vin"));
                vehicle.setMake(rows.getString("make"));
                vehicle.setModel(rows.getString("model"));
                vehicle.setPrice(rows.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public List<Vehicle> byYearRange(int minYear, int maxYear) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement queryEx = conn.prepareStatement("SELECT * FROM Vehicles WHERE year BETWEEN ? AND ?")) {
            queryEx.setInt(1, minYear);
            queryEx.setInt(2, maxYear);
            try (ResultSet rows = queryEx.executeQuery()) {
                while (rows.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVin(rows.getInt("vin"));
                    vehicle.setMake(rows.getString("make"));
                    vehicle.setModel(rows.getString("model"));
                    vehicle.setPrice(rows.getDouble("price"));
                    vehicles.add(vehicle);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
    public List<Vehicle> getByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement queryEx = conn.prepareStatement("SELECT * FROM Vehicles WHERE color = ?")) {
            queryEx.setString(1, color);
            ResultSet rows = queryEx.executeQuery();
            if (rows.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(rows.getInt("vin"));
                vehicle.setMake(rows.getString("make"));
                vehicle.setModel(rows.getString("model"));
                vehicle.setPrice(rows.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
    public List<Vehicle> getByMileageRange(int minRange, int maxRange ) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement queryEx = conn.prepareStatement("SELECT * FROM Vehicles WHERE mileage BETWEEN ? AND ?")) {
            queryEx.setInt(1, minRange);
            queryEx.setInt(2, maxRange);
            ResultSet rows = queryEx.executeQuery();
            if (rows.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(rows.getInt("vin"));
                vehicle.setMake(rows.getString("make"));
                vehicle.setModel(rows.getString("model"));
                vehicle.setPrice(rows.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }
    public List<Vehicle> getByType(String type) {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement queryEx = conn.prepareStatement("SELECT * FROM Vehicles WHERE type = ?")) {
            queryEx.setString(1, type);
            ResultSet rows = queryEx.executeQuery();
            if (rows.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(rows.getInt("vin"));
                vehicle.setMake(rows.getString("make"));
                vehicle.setModel(rows.getString("model"));
                vehicle.setPrice(rows.getDouble("price"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicles;
    }

    public void deleteVehicle(int vin) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement deleteEx = conn.prepareStatement("DELETE FROM Vehicles WHERE vin = ?")) {
            deleteEx.setInt(1, vin);
            int rowsDeleted = deleteEx.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Delete Successful");
            } else {
                System.out.println("Nothing was deleted. Verify the Vin.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
