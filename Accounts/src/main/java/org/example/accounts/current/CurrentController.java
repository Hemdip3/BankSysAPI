package org.example.accounts.current;

import org.example.accounts.savings.Savings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/current")
public class CurrentController {
    @Autowired
    private CurrentServices service;

    @PostMapping("/add")
    public Current addAccount(@RequestBody Current account){
        return service.addAccount(account);
    }

    @GetMapping("/get")
    public List<Current> getAccounts(){
        return service.getAccounts();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable int id){
       service.deleteAccount(id);
    }

    @PutMapping("/deposit/{id}/{amount}")
    public Double deposit(@PathVariable int id, @PathVariable double amount){
        return service.deposit(id, amount);
    }

    @PutMapping("/withdraw/{id}/{amount}")
    public Double withdraw(@PathVariable int id,@PathVariable double amount){
        return service.withdraw(id, amount);
    }
}
