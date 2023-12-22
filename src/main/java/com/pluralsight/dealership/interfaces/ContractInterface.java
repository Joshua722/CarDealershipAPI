package com.pluralsight.dealership.interfaces;

import com.pluralsight.dealership.models.Contract;

public interface ContractInterface {
    Contract getById(int id);
    Contract newContract(Contract contract);
}
