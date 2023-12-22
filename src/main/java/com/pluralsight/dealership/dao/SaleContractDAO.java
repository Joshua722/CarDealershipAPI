package com.pluralsight.dealership.dao;

import com.pluralsight.dealership.interfaces.ContractInterface;
import com.pluralsight.dealership.models.Contract;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.pluralsight.dealership.dao.VehicleDAO.dataSource;

@Component
public class SaleContractDAO implements ContractInterface {
    @Override
    public Contract getById(int id) {
        Contract contract = null;
        try (Connection conn = dataSource.getConnection();
             PreparedStatement query = conn.prepareStatement("SELECT * FROM `sales contracts` WHERE id = ?")) {
            query.setInt(1, id);
            ResultSet rows = query.executeQuery();
            if (rows.next()) {
                contract = new Contract();
                contract.setDate(rows.getString("date"));
                contract.setCustomerName(rows.getString("customer"));
                contract.setCustomerEmail(rows.getString("Customer_Email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;

    }

    @Override
    public Contract newContract(Contract contract) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO `sales contracts`(date,customer,customer_email,vin) VALUES (?,?,?,?)")) {
            pstmt.setInt(1, Integer.parseInt(contract.getDate()));
            pstmt.setString(2, contract.getCustomerEmail());
            pstmt.setString(3, contract.getCustomerName());
            pstmt.setString(4, contract.getVin());
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Contract has been added.");
                return contract;
            } else {
                System.out.println("Something went wrong, failed to add.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contract;
    }
}
