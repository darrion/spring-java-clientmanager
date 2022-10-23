package io.darrion.clientmanager.factory;

import org.springframework.beans.factory.annotation.Autowired;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.AssignmentEntity;
import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.entity.composite.AssignmentId;
import io.darrion.clientmanager.model.Assignment;
import io.darrion.clientmanager.repo.AdvisorRepository;
import io.darrion.clientmanager.repo.ClientRepository;

public class AssignmentFactory {

    private AssignmentFactory() {}

    static AdvisorRepository advisorRepository;

    static ClientRepository clientRepository;

    @Autowired
    private static void getAdvisorRepository(AdvisorRepository advisorRepository) {
        AssignmentFactory.advisorRepository = advisorRepository;
    }

    @Autowired
    private static void getClientRepository(ClientRepository clientRepository) {
        ClientFactory.clientRepository = clientRepository;
    }
    
    public static AssignmentEntity create(Assignment assignment, AdvisorEntity advisorEntity, ClientEntity clientEntity) {
        AssignmentEntity assignmentEntity = new AssignmentEntity();
        assignmentEntity.setId(new AssignmentId(assignment.getAdvisorId(), assignment.getClientId()));
        assignmentEntity.setAdvisorEntity(advisorEntity);
        assignmentEntity.setClientEntity(clientEntity);
        return assignmentEntity;
    }
}
