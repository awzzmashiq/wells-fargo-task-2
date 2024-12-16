package com.wellsfargo.counselor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired private ClientRepository clientRepository;

    public List<Client> getAllClients() { return clientRepository.findAll(); }
    public Client getClientById(Long id) { return clientRepository.findById(id).orElse(null); }
    public Client createClient(Client client) { return clientRepository.save(client); }
    public Client updateClient(Long id, Client updatedClient) {
        return clientRepository.findById(id)
            .map(client -> {
                client.setFirstName(updatedClient.getFirstName());
                client.setLastName(updatedClient.getLastName());
                client.setAddress(updatedClient.getAddress());
                client.setPhone(updatedClient.getPhone());
                client.setEmail(updatedClient.getEmail());
                return clientRepository.save(client);
            }).orElse(null);
    }
    public void deleteClient(Long id) { clientRepository.deleteById(id); }
}
