package org.example.client;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {


    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        return service.addClient(client);
    }

    @PostMapping("/add/{type}")
    public Client addClient(@PathVariable String type, @RequestBody Client client){
        return service.addClient(type, client);
    }

    @GetMapping("/get")
    public List<Client> getClient() {
        return service.getClients();
    }

    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client) {
        return service.updateClient(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable int id) {
        service.RemoveClient(id);
    }
//    @PutMapping("/{name}/{accountType}/{type}/{amount}")
//    public double performTransaction(
//            @PathVariable String name,
//            @PathVariable String accountType,
//            @PathVariable String type,
//            @PathVariable double amount) {
//
//        return service.transaction(name, accountType, type, amount);
//    }



}
