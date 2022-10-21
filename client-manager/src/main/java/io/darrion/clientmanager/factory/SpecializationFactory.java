package io.darrion.clientmanager.factory;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.SpecializationEntity;
import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.model.Specialization;
import io.darrion.clientmanager.repo.AdvisorRepository;
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
