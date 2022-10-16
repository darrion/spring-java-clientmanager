package io.darrion.clientmanager.mapper;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.ClientEntity;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.model.Client;

public interface Mapper {
    
    Advisor advisorEntityToAdvisor(AdvisorEntity advisorEntity);
    AdvisorEntity advisorToAdvisorEntity(Advisor advisor);

    Client clientEntityToClient(ClientEntity clientEntity);
    ClientEntity clientToClientEntity(Client client);
    
}
