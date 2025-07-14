package org.example.transactions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Transactions {

    @Id
    @GeneratedValue
    int transactionId;
    int clientId;
    String accountType;
    String transactionType;
    Double amount;

    public Transactions(){

    }

    public Transactions( String accountType, String transactionType,int clientId, Double amount) {
        this.clientId = clientId;
        this.accountType = accountType;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Transactions(int clientId, Double amount) {
        this.clientId = clientId;
        this.amount = amount;
    }



    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

}
