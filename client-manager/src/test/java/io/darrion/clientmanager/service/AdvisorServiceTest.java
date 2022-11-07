package io.darrion.clientmanager.service;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.exception.AdvisorEmailDuplicateException;
import io.darrion.clientmanager.model.Advisor;
import io.darrion.clientmanager.repo.AdvisorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AdvisorServiceTest {

    @Autowired
    AdvisorService advisorService;

    @Autowired
    Advisor advisor;

    @Test
    void add() throws AdvisorEmailDuplicateException {
        advisor.setFirstName("Hafsa");
        advisor.setLastName("Snyder");
        advisor.setEmail("hafsas@email.com");
        AdvisorEntity advisorEntity = advisorService.add(advisor);
        assertThat(advisorEntity.getId()).isNotNull();
        assertThat(advisorEntity.getEmail()).isEqualTo("hafsas@email.com");
    }

    @Test
    void update() {
    }

    @Test
    void assign() {
    }

    @Test
    void getClients() {
    }
}