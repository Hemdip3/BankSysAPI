package org.example.transactions;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TransactionServices {

    private TransactionRepo repo;

    public double transaction(String accountType, String type, int id, double amount) {


        String url = "http://localhost:8080/" + accountType + "/" + type + "/" + id + "/" + amount;

       WebClient.create()
                .put()
                .uri(url)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return amount;
    }
}
