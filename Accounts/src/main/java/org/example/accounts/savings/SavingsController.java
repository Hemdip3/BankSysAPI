package org.example.accounts.savings;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savings")
public class SavingsController {

    private final SavingServices service;

    public SavingsController(SavingServices service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Savings addAccount(@RequestBody Savings account){
        return service.addAccount(account);
    }

    @GetMapping("/get")
    public List<Savings> getAccounts(){
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
    public String withdraw(@PathVariable int id,@PathVariable double amount){
        return service.withdraw(id, amount);
    }


}
