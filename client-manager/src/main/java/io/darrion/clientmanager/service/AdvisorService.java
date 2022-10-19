package io.darrion.clientmanager.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.repo.AdvisorRepository;

@Service
public class AdvisorService {
    
    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired
    ModelMapper modelMapper;

    public AdvisorEntity save(Advisor advisor) {
        AdvisorEntity advisorEntity = modelMapper.map(advisor, AdvisorEntity.class);
        return advisorRepository.save(advisorEntity);
    }
}
