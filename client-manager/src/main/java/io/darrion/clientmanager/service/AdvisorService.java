package io.darrion.clientmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.repo.AdvisorRepository;
import io.darrion.clientmanager.repo.ClientRepository;

@Service
public class AdvisorService {
    
    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired
    ClientRepository clientRepository;

    public void add(AdvisorEntity advisorEntity) {
        advisorRepository.save(advisorEntity);
    }
    public void remove(AdvisorEntity advisorEntity) {
        advisorRepository.delete(advisorEntity);
    }
}
