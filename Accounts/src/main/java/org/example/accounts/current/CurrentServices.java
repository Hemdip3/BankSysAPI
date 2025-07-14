package org.example.accounts.current;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentServices {


    private final CurrentRepo repo;

    public CurrentServices(CurrentRepo repo) {
        this.repo = repo;
    }

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
        Current account = repo.findByClientID(id);
        double newBalance = account.getBalance() +amount;
        account.setBalance(newBalance);
        repo.save(account);
        return newBalance;
    }




    public double withdraw(int id, double amount){

        Current account = repo.findByClientID(id);
        double newBalance = account.getBalance() -amount;
        account.setBalance(newBalance);
        repo.save(account);
        return newBalance;
    }
}
