package com.pluralsight.dealership.controller;

import com.pluralsight.dealership.dao.LeaseContractDAO;
import com.pluralsight.dealership.models.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeaseContractsController {
    private LeaseContractDAO leaseContractDAO;
    @Autowired
    public LeaseContractsController(LeaseContractDAO leaseContractDAO){
        this.leaseContractDAO = leaseContractDAO;
    }
    @PostMapping("/addLeaseContract")
    public Contract addContract(@RequestBody Contract contract){
        return leaseContractDAO.newContract(contract);
    }
    @GetMapping("/LeaseContractID")
    public Contract getByID(@PathVariable int id){
        return leaseContractDAO.getById(id);
    }
}
