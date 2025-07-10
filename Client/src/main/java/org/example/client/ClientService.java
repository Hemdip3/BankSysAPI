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

        repo.save(client);

        SavingsDTO savings= new SavingsDTO();
        savings.setClientID(client.getId());
        savings.setClientID(0);

        WebClient.create()
                .post()
                .uri("http://localhost:8080/savings/add")
                .bodyValue(savings)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return client;
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

    public Client createSavings(Client client){


        SavingsDTO savings= new SavingsDTO();
        savings.setClientID(client.getId());
        savings.setClientID(0);

        WebClient.create()
                .post()
                .uri("http://localhost:8080/savings/add")
                .bodyValue(savings)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return client;

    }


}
