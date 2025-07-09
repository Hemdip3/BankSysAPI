package org.example.accounts.current;

import org.example.accounts.savings.Savings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentServices {
    private Current account;
    @Autowired
    private CurrentRepo repo;
    private double amount;

    public Current addAccount(Current account){
        return repo.save(account);
    }

    public List<Current> getAccounts(){
        return repo.findAll();
    }

    public void deleteAccount(int id){
        repo.deleteById(id);
    }

    public double deposit(int id, double amount){
        Current account = repo.findById(id).orElseThrow();
        double newBalance = account.getBalance() +amount;
        account.setBalance(newBalance);
        repo.save(account);
        return newBalance;
    }

    public double withdraw(int id, double amount){

        Current account = repo.findById(id).orElseThrow();
        double newBalance = account.getBalance() -amount;
        account.setBalance(newBalance);
        repo.save(account);
        return newBalance;
    }
}
