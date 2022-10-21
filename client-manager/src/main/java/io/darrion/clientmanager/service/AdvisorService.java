package io.darrion.clientmanager.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.exception.AdvisorEmailDuplicateException;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.repo.AdvisorRepository;

@Service
public class AdvisorService {
    
    @Autowired
    AdvisorRepository advisorRepository;

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
}
