package io.darrion.clientmanager.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.repo.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository; 

    @Autowired 
    ModelMapper modelMapper; 
    
    public ClientEntity add(Client client) {
        ClientEntity clientEntity = modelMapper.map(client, ClientEntity.class); 
        return clientRepository.save(clientEntity); 
    }
}
