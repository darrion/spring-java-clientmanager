package com.example.clientmanager.service;

import com.example.clientmanager.exception.AdvisorDoesNotExistException;
import com.example.clientmanager.exception.ClientEmailDuplicateException;
import com.example.clientmanager.config.factory.ClientFactory;
import com.example.clientmanager.repo.AdvisorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.clientmanager.entity.ClientEntity;
import com.example.clientmanager.model.Client;
import com.example.clientmanager.repo.ClientRepository;

import javax.validation.Valid;

@Service
@Validated
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired 
    ModelMapper modelMapper;
    
    public ClientEntity add(@Valid Client client) throws AdvisorDoesNotExistException, ClientEmailDuplicateException {

        ClientEntity clientEntity = ClientFactory.create(client);
        String clientEmail = clientEntity.getEmail();
        Boolean exists = clientRepository.existsByEmail(clientEmail);
        if (Boolean.TRUE.equals(exists)) {
            throw new ClientEmailDuplicateException(clientEmail);
        }
        clientEntity = clientRepository.save(clientEntity);

        return clientEntity;
    }

    public ClientEntity update(Client client) throws AdvisorDoesNotExistException, ClientEmailDuplicateException {

        Integer clientId = client.getId();
        ClientEntity targetClientEntity = clientRepository.findById(clientId).orElse(null);
        if (targetClientEntity == null) {
            return this.add(client);
        }
        Integer targetId = targetClientEntity.getId();
        ClientEntity clientEntity = ClientFactory.create(client);
        clientEntity.setId(targetId);

        clientEntity = clientRepository.save(clientEntity);

        return clientEntity;
    }

    
}
