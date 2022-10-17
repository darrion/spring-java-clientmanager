package io.darrion.clientmanager.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.entity.SpecializationEntity;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.model.Specialization;
import io.darrion.clientmanager.repo.AdvisorRepository;
import io.darrion.clientmanager.repo.ClientRepository;
import io.darrion.clientmanager.repo.SpecializationRepository;

@Service
public class AdvisorService {
    
    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SpecializationRepository specializationRepository;

    @Autowired
    ModelMapper modelMapper;

    public AdvisorEntity add(Advisor advisor) {
        AdvisorEntity advisorEntity = modelMapper.map(advisor, AdvisorEntity.class);
        return advisorRepository.save(advisorEntity);
    }

    public AdvisorEntity update(Advisor advisor) {
        return this.add(advisor);
    }

    public ClientEntity assign(Advisor advisor, Client client) {
        client.setAdvisor(advisor);
        ClientEntity clientEntity = modelMapper.map(client, ClientEntity.class);
        return clientRepository.save(clientEntity);
    }
    
    public void remove(Advisor advisor) {
        AdvisorEntity advisorEntity = modelMapper.map(advisor, AdvisorEntity.class);
        advisorRepository.delete(advisorEntity);
    }
}
