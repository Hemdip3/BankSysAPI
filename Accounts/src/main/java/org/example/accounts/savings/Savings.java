package org.example.accounts.savings;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Savings {
    private int clientID;
    @Id
    @GeneratedValue
    private int id;
    private double balance;

    public Savings(){

    }
    public Savings(int clientID, int id) {
        this.balance = 0;
        this.clientID = clientID;
    }
    public Savings(int clientID, int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.clientID = clientID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getId() {
        return id;
    }



    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
