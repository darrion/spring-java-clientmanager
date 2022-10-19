package io.darrion.clientmanager.factory;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.exception.ClientEmailDuplicateException;
import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.repo.AdvisorRepository;
import io.darrion.clientmanager.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientFactory {

    static AdvisorRepository advisorRepository;
    static ClientRepository clientRepository;

    @Autowired
    public void setAdvisorRepository(AdvisorRepository advisorRepository) {
        ClientFactory.advisorRepository = advisorRepository;
    }

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        ClientFactory.clientRepository = clientRepository;
    }

    public static ClientEntity create(Client client) throws AdvisorDoesNotExistException, ClientEmailDuplicateException {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName(client.getFirstName());
        clientEntity.setMiddleName(client.getMiddleName());
        clientEntity.setLastName(client.getLastName());
        clientEntity.setEmail(client.getEmail());
        AdvisorEntity advisorEntity = advisorRepository.findById(client.getAdvisorId()).orElse(null);
        if (advisorEntity == null) {
            throw new AdvisorDoesNotExistException();
        }
        clientEntity.setAdvisorEntity(advisorEntity);
        return clientEntity;
    }
}
