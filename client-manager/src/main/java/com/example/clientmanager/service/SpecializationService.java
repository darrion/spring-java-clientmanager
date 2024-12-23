package com.example.clientmanager.service;

import com.example.clientmanager.exception.AdvisorDoesNotExistException;
import com.example.clientmanager.config.factory.SpecializationFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clientmanager.entity.AdvisorEntity;
import com.example.clientmanager.entity.SpecializationEntity;
import com.example.clientmanager.model.Specialization;
import com.example.clientmanager.repo.AdvisorRepository;
import com.example.clientmanager.repo.SpecializationRepository;

@Service
public class SpecializationService {

    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired
    SpecializationRepository specializationRepository;

    @Autowired
    ModelMapper modelMapper;

    public SpecializationEntity add(Specialization specialization) throws AdvisorDoesNotExistException {

        Integer advisorId = specialization.getAdvisorId();
        AdvisorEntity advisorEntity = advisorRepository.findById(advisorId).orElse(null);
        if (advisorEntity == null) {
            throw new AdvisorDoesNotExistException();
        }
        SpecializationEntity specializationEntity = SpecializationFactory.create(specialization, advisorEntity);
        return specializationRepository.save(specializationEntity);
    }


    public void remove(Specialization specialization) {

        SpecializationEntity specializationEntity = SpecializationFactory.create(specialization, null);
        specializationRepository.delete(specializationEntity);
    }
}
