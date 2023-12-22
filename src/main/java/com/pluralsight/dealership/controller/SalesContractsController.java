package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.SaleContractDAO;
import com.pluralsight.dealership.models.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class SalesContractsController {
    private SaleContractDAO saleContractDAO;

    @Autowired
    public SalesContractsController(SaleContractDAO saleContractDAO) {
        this.saleContractDAO = saleContractDAO;
    }

    @PostMapping("/addSalesContract")
    public Contract addContract(@RequestBody Contract contract) {
        return saleContractDAO.newContract(contract);
    }

    @GetMapping("/SalesContractID")
    public Contract getByID(@PathVariable int id) {
        return saleContractDAO.getById(id);
    }

}
