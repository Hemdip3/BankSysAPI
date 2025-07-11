package org.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    public ClientRepo repo;

    public Client addClient(Client client){

        return repo.save(client);

    }

    public List<Client> getClients(){
        return repo.findAll();
    }

    public void RemoveClient(int id){
        repo.deleteById(id);
    }

    public Client updateClient(Client client) {

        Client c = repo.getReferenceById(client.getId());

        c.setFirstName(client.getFirstName());
        c.setLastName(client.getLastName());
        c.setEmail(client.getEmail());

        return repo.save(c);
    }

    public Client addClient(String type, Client client)
    {

        repo.save(client);
        String url = "http://localhost:8080/" + type + "/add";

        accountsDTO savings= new accountsDTO();
        savings.setClientID(client.getId());
        savings.setBalance(100);

        WebClient.create()
                .post()
                .uri(url)
                .bodyValue(savings)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return client;

    }


}
