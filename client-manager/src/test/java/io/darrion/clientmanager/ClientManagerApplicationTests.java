package com.example.clientmanager;

import com.example.clientmanager.repo.AdvisorRepository;
import com.example.clientmanager.repo.ClientRepository;
import com.example.clientmanager.repo.SpecializationRepository;
import com.example.clientmanager.service.AdvisorService;
import com.example.clientmanager.service.ClientService;
import com.example.clientmanager.service.SpecializationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClientManagerApplicationTests {

    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SpecializationRepository specializationRepository;

    @Autowired
    AdvisorService advisorService;

    @Autowired
    ClientService clientService;

    @Autowired
    SpecializationService specializationService;

    @Test
    public void contextLoads() {

        assertThat(advisorRepository).isNotNull();
        assertThat(clientRepository).isNotNull();
        assertThat(specializationRepository).isNotNull();

        assertThat(advisorService).isNotNull();
        assertThat(clientService).isNotNull();
        assertThat(specializationService).isNotNull();
    }
}
