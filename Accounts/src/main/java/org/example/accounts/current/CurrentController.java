package org.example.accounts.current;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/current")
public class CurrentController {

    private final CurrentServices service;

    public CurrentController(CurrentServices service) {
        this.service = service;
    }

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
    public String withdraw(@PathVariable int id,@PathVariable double amount){
        return service.withdraw(id, amount);
    }
}
