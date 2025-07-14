package org.example.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionServices service;

    @PutMapping("/{accountType}/{type}/{id}/{amount}")
    public double performTransaction(

            @PathVariable String accountType,
            @PathVariable String type,
            @PathVariable int id,
            @PathVariable double amount) {

        return service.transaction( accountType, type, id, amount);
    }
}
