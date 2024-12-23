package com.example.clientmanager.repo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.clientmanager.entity.AdvisorEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdvisorRepositoryTest {

    @Autowired
    AdvisorRepository advisorRepository;

    @Autowired
    EntityManager entityManager;

    @BeforeAll
    void beforeAll() {
        entityManager.persist(new AdvisorEntity(
                1,
                "Kylo",
                null,
                "Osborne",
                "kylosb@email.com",
                null,
                null));
    }

    @Test
    void testExistsByEmail() {

        Boolean exists = advisorRepository.existsByEmail("kylosb@email.com");
        assertThat(exists).isTrue();
    }

    @Test
    void testFindByEmail() {

        AdvisorEntity advisorEntity = advisorRepository.findByEmail("kylosb@email.com");
        assertThat(advisorEntity.getEmail()).isEqualTo("kylosb@email.com");
    }
}
