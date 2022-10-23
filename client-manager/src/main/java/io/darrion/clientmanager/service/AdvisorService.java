package io.darrion.clientmanager.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.AssignmentEntity;
import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.exception.AdvisorEmailDuplicateException;
import io.darrion.clientmanager.exception.ClientDoesNotExistException;
import io.darrion.clientmanager.factory.AssignmentFactory;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Assignment;
import io.darrion.clientmanager.repo.AdvisorRepository;
import io.darrion.clientmanager.repo.ClientRepository;

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

    public AssignmentEntity assign(Assignment assignment) throws AdvisorDoesNotExistException, ClientDoesNotExistException {
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
        return AssignmentFactory.create(assignment, advisorEntity, clientEntity);
    }
}
