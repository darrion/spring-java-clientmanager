package io.darrion.clientmanager.service;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.exception.ClientEmailDuplicateException;
import io.darrion.clientmanager.factory.ClientFactory;
import io.darrion.clientmanager.repo.AdvisorRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.repo.ClientRepository;

import java.util.Optional;

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
