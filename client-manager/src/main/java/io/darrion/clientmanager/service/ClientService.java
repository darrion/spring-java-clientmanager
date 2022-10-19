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

import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.repo.ClientRepository;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired 
    ModelMapper modelMapper;
    
    public ClientEntity save(Client client) throws AdvisorDoesNotExistException, ClientEmailDuplicateException {
        ClientEntity clientEntity = ClientFactory.create(client);
        AdvisorEntity advisorEntity = clientEntity.getAdvisorEntity();
        String clientEmail = clientEntity.getEmail();
        if (advisorEntity != null && !advisorRepository.existsById(advisorEntity.getId())) {
            throw new AdvisorDoesNotExistException();
        }
        try {
            clientEntity = clientRepository.save(clientEntity);
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMostSpecificCause().getMessage().contains(String.format("(email)=(%s) already exists", clientEmail))) {
                throw new ClientEmailDuplicateException(clientEmail);
            }
        }
        return clientEntity;
    }
}
