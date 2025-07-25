package org.example.accounts.savings;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingServices {
    private Savings account;
    @Autowired
    private SavingsRepo repo;
    private double amount;

    public Savings addAccount(Savings account){
        return repo.save(account);
    }

    public List<Savings> getAccounts(){
        return repo.findAll();
    }

    public void deleteAccount(int id){
        repo.deleteById(id);
    }

    public double deposit(int id, double amount){
        Savings account = repo.findByClientID(id);
        double newBalance = account.getBalance() +amount;
        account.setBalance(newBalance);
        repo.save(account);
        return newBalance;
    }

    public String withdraw(int id, double amount){

        if(repo.findByClientID(id).getBalance()-amount<0) {
            Savings account = repo.findByClientID(id);
            double newBalance = account.getBalance() - amount;
            account.setBalance(newBalance);
            repo.save(account);
            return String.valueOf(newBalance);
        }
        return "insufficient account balance";
    }


}
