package org.example.accounts.current;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Current {
    private int clientID;
    @Id
    @GeneratedValue
    private int id;

    public Current(){

    }
    public Current(int clientID, int id) {
        this.clientID = clientID;
        this.balance = 0;
    }

    public Current(int clientID, int id, double balance) {
        this.clientID = clientID;
        this.id = id;
        this.balance = balance;
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

    private double balance;
}
