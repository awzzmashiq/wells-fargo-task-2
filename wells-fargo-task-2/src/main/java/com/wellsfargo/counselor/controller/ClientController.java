package com.wellsfargo.counselor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired private ClientService clientService;

    @GetMapping public List<Client> getAllClients() { return clientService.getAllClients(); }
    @GetMapping("/{id}") public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }
    @PostMapping public Client createClient(@RequestBody Client client) { return clientService.createClient(client); }
    @PutMapping("/{id}") public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(id, client);
        return updatedClient != null ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id); return ResponseEntity.noContent().build();
    }
}
