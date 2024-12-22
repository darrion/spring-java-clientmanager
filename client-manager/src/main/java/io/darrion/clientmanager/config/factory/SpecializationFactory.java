package com.example.clientmanager.config.factory;

import com.example.clientmanager.entity.AdvisorEntity;
import com.example.clientmanager.entity.SpecializationEntity;
import com.example.clientmanager.model.Specialization;
import com.example.clientmanager.repo.AdvisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpecializationFactory {

    static AdvisorRepository advisorRepository;

    @Autowired
    public void setAdvisorRepository(AdvisorRepository advisorRepository) {
        SpecializationFactory.advisorRepository = advisorRepository;
    }

    public static SpecializationEntity create(Specialization specialization, AdvisorEntity advisorEntity) {

        SpecializationEntity specializationEntity = new SpecializationEntity();
        specializationEntity.setAdvisorEntity(advisorEntity);
        specializationEntity.setId(specialization.getId());
        specializationEntity.setFocus(specialization.getFocus());

        return specializationEntity;
    }
}
