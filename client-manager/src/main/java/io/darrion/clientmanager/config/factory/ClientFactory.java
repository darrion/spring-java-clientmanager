package io.darrion.clientmanager.config.factory;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.exception.AdvisorDoesNotExistException;
import io.darrion.clientmanager.model.Client;
import io.darrion.clientmanager.repo.AdvisorRepository;
import io.darrion.clientmanager.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientFactory {

    private ClientFactory() {}

    static AdvisorRepository advisorRepository;
    static ClientRepository clientRepository;

    @Autowired
    public static void setAdvisorRepository(AdvisorRepository advisorRepository) {
        ClientFactory.advisorRepository = advisorRepository;
    }

    @Autowired
    public static void setClientRepository(ClientRepository clientRepository) {
        ClientFactory.clientRepository = clientRepository;
    }

    public static ClientEntity create(Client client) throws AdvisorDoesNotExistException {

        ClientEntity clientEntity = new ClientEntity();

        AdvisorEntity advisorEntity = null;

        Integer advisorId = client.getAdvisorId();

        if (advisorId != null) {
            advisorEntity = advisorRepository.findById(client.getAdvisorId()).orElse(null);
        }

        if (advisorEntity == null) {
            throw new AdvisorDoesNotExistException();
        }

        clientEntity.setFirstName(client.getFirstName());
        clientEntity.setMiddleName(client.getMiddleName());
        clientEntity.setLastName(client.getLastName());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setAdvisorEntity(advisorEntity);

        return clientEntity;
    }
}
