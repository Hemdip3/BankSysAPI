package org.example.transactions;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TransactionServices {

    @Autowired
    private TransactionRepo repo;

    @Transactional
    public double transaction(String accountType, String type, int id, double amount) {

        Transactions transaction = new Transactions(accountType,type,id,amount);

        String url = "http://localhost:8080/" + accountType + "/" + type + "/" + id + "/" + amount;

       WebClient.create()
                .put()
                .uri(url)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

       repo.save(transaction);

        return amount;
    }
}
