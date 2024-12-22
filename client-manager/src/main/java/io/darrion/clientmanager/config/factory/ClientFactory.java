package com.example.clientmanager.config.factory;

import com.example.clientmanager.entity.AdvisorEntity;
import com.example.clientmanager.entity.ClientEntity;
import com.example.clientmanager.exception.AdvisorDoesNotExistException;
import com.example.clientmanager.model.Client;
import com.example.clientmanager.repo.AdvisorRepository;
import com.example.clientmanager.repo.ClientRepository;
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
