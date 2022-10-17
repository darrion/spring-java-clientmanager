package io.darrion.clientmanager.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.SpecializationEntity;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Specialization;
import io.darrion.clientmanager.repo.AdvisorRepository;
import io.darrion.clientmanager.repo.SpecializationRepository;

@Service
public class SpecializationService {

    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired
    SpecializationRepository specializationRepository;

    @Autowired
    ModelMapper modelMapper;

    public SpecializationEntity add(Specialization specialization) {
        AdvisorEntity advisorEntity = null; 
        Advisor advisor = specialization.getAdvisor();
        Optional<AdvisorEntity> optAdvEnt = advisorRepository.findById(advisor.getId());
        if (optAdvEnt.isPresent()) {
            advisorEntity = optAdvEnt.get();
        }
        SpecializationEntity specializationEntity = modelMapper.map(specialization, SpecializationEntity.class);
        specializationEntity.setAdvisorEntity(advisorEntity);
        return specializationRepository.save(specializationEntity);
    }
}
