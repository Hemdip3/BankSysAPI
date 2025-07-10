package org.example.client;


public class SavingsDTO {
    private int clientID;
    private double balance=0;

    public SavingsDTO() {
    }

    public SavingsDTO(int clientID, double balance) {
        this.clientID = clientID;
        this.balance = balance;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
