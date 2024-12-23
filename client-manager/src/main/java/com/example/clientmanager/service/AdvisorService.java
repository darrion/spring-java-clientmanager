package com.example.clientmanager.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clientmanager.entity.AdvisorEntity;
import com.example.clientmanager.entity.ClientEntity;
import com.example.clientmanager.exception.AdvisorDoesNotExistException;
import com.example.clientmanager.exception.AdvisorEmailDuplicateException;
import com.example.clientmanager.exception.ClientDoesNotExistException;
import com.example.clientmanager.model.Advisor;
import com.example.clientmanager.model.Assignment;
import com.example.clientmanager.repo.AdvisorRepository;
import com.example.clientmanager.repo.ClientRepository;

@Service
public class AdvisorService {
    
    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired 
    ClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;

    public AdvisorEntity add(Advisor advisor) throws AdvisorEmailDuplicateException {
        AdvisorEntity advisorEntity = modelMapper.map(advisor, AdvisorEntity.class);
        String advisorEmail = advisor.getEmail();
        Boolean exists = advisorRepository.existsByEmail(advisorEmail);
        if (Boolean.TRUE.equals(exists)) {
            throw new AdvisorEmailDuplicateException(advisorEmail);
        }
        return advisorRepository.save(advisorEntity);
    }

    public AdvisorEntity update(Advisor advisor) throws AdvisorEmailDuplicateException {
        Integer advisorId = advisor.getId();
        AdvisorEntity targetAdvisorEntity = advisorRepository.findById(advisorId).orElse(null);
        if (targetAdvisorEntity == null) {
            return this.add(advisor); // Or redirect
        }
        AdvisorEntity advisorEntity = modelMapper.map(advisor, AdvisorEntity.class);
        advisorEntity.setId(targetAdvisorEntity.getId());
        return advisorRepository.save(advisorEntity);
    }

    public ClientEntity assign(Assignment assignment) throws AdvisorDoesNotExistException, ClientDoesNotExistException {
        Integer advisorId = assignment.getAdvisorId();
        Integer clientId = assignment.getClientId();
        AdvisorEntity advisorEntity = advisorRepository.findById(advisorId).orElse(null);
        ClientEntity clientEntity = clientRepository.findById(clientId).orElse(null);
        if (advisorEntity == null) {
            throw new AdvisorDoesNotExistException();
        }
        if (clientEntity == null) {
            throw new ClientDoesNotExistException();
        }
        clientEntity.setAdvisorEntity(advisorEntity);
        return clientRepository.save(clientEntity);
    }

    public List<ClientEntity> getClients(Advisor advisor) throws AdvisorDoesNotExistException {
        Integer advisorId = advisor.getId();
        AdvisorEntity advisorEntity = advisorRepository.findById(advisorId).orElse(null);
        if (advisorEntity == null) {
            throw new AdvisorDoesNotExistException();
        }
        return clientRepository.findClientsByAdvisorId(advisorId);
    }
}
