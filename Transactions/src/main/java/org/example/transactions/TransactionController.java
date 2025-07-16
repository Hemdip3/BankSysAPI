package org.example.transactions;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TransactionController {

    private final TransactionServices service;

    public TransactionController(TransactionServices service){
        this.service = service;
    }

    @PutMapping("/transaction/{accountType}/{type}/{id}/{amount}")
    public String performTransaction(

            @PathVariable String accountType,
            @PathVariable String type,
            @PathVariable int id,
            @PathVariable double amount) {

        return service.transaction( accountType, type, id, amount);
    }

    @PutMapping("/transfer/{senderAccountType}/{senderId}/{amount}/{recipientAccountType}/{recipientId}")
    public String transfer(@PathVariable String senderAccountType,
                         @PathVariable String recipientAccountType,
                         @PathVariable int senderId,
                         @PathVariable int recipientId,
                         @PathVariable double amount){

        return service.transfer( senderAccountType, recipientAccountType,  senderId,  recipientId, amount);

    }
}
