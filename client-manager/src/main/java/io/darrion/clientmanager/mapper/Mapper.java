package com.example.clientmanager.mapper;

import com.example.clientmanager.entity.AdvisorEntity;
import com.example.clientmanager.entity.ClientEntity;
import com.example.clientmanager.model.Advisor;
import com.example.clientmanager.model.Client;

public interface Mapper {
    
    Advisor advisorEntityToAdvisor(AdvisorEntity advisorEntity);
    AdvisorEntity advisorToAdvisorEntity(Advisor advisor);

    Client clientEntityToClient(ClientEntity clientEntity);
    ClientEntity clientToClientEntity(Client client);
    
}
