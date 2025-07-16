package org.example.client;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepo repo;

    public ClientService(ClientRepo repo){
        this.repo = repo;
    }


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



    @Transactional
    public Client addClient(String type, Client client)
    {

        repo.save(client);
        String url = "http://localhost:8080/" + type + "/add";

        accountsDTO account = new accountsDTO();

        account.setClientID(client.getId());
        account.setBalance(1000);

        WebClient.create()
                .post()
                .uri(url)
                .bodyValue(account)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return client;

    }
//
//    public double transaction(String name,String accountType,String type, double amount){
//
//        Client client = repo.findByFirstName(name);
//        int id = client.getId();
//
//        String url = "http://localhost:8080/" + accountType +"/"+ type +"/"+ id+"/"+amount;
//
//        return WebClient.create()
//                .put()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(Double.class)
//                .block();
//    }

}
