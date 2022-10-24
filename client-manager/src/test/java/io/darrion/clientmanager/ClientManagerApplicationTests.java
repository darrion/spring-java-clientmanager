package io.darrion.clientmanager;

import io.darrion.clientmanager.repo.AdvisorRepository;
import io.darrion.clientmanager.repo.ClientRepository;
import io.darrion.clientmanager.repo.SpecializationRepository;
import io.darrion.clientmanager.service.AdvisorService;
import io.darrion.clientmanager.service.ClientService;
import io.darrion.clientmanager.service.SpecializationService;
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
