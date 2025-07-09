package org.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;


    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        return service.addClient(client);
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


}
