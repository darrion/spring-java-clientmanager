package io.darrion.clientmanager.service;

import java.util.Optional;

import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.factory.SpecializationFactory;
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
