package org.example.transactions;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TransactionServices {


    private final TransactionRepo repo;

    public TransactionServices(TransactionRepo repo) {
        this.repo = repo;
    }

    @Transactional
    public String transaction(String accountType, String type, int id, double amount) {

        String response;
        if (amount > 0) {
            Transactions transaction = new Transactions(accountType, type, id, amount);

            String url = "http://localhost:8080/" + accountType + "/" + type + "/" + id + "/" + amount;

           response = WebClient.create()
                    .put()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            if (!"insufficient account balance".equals(response)) {
                repo.save(transaction);
            }
        }
        else {
            response = "invalid amount";
        }
        return response;
    }

    @Transactional
    public String transfer(String senderAccountType, String recipientAccountType,int senderId, int recipientId,
                           double amount) {

        String withdrawResponse = this.transaction(senderAccountType, "withdraw", senderId, amount);
        if (!"insufficient account balance".equals(withdrawResponse)) {
             String depositResponse = this.transaction(recipientAccountType, "deposit", recipientId, amount);
             return depositResponse;
        }

        return withdrawResponse;
    }

}

