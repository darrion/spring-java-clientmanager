package io.darrion.clientmanager.repo;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.ClientEntity;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void testDoesExistByEmail() {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName("Iqaluk");
        clientEntity.setLastName("Guo");
        clientEntity.setEmail("iqalukguo@esmail.com");
        entityManager.persist(clientEntity);
        Boolean result = clientRepository.existsByEmail("iqalukguo@esmail.com");
        assertThat(result).isTrue();
    }

    @Test 
    void testDoesNotExistByEmail() {
        Boolean result = clientRepository.existsByEmail("iqalukguo@email.com");
        assertThat(result).isFalse();
    }

    @Test
    void testGetByEmail() {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName("Iqaluk");
        clientEntity.setLastName("Guo");
        clientEntity.setEmail("iqalukguo@email.com");
        entityManager.persist(clientEntity);
        ClientEntity result = clientRepository.findByEmail(clientEntity.getEmail());
        assertThat(result.getEmail()).isEqualTo("iqalukguo@email.com");
    }

    @Test
    void testFindClientsByAdvisorId() {
        
        ClientEntity clientEntity1 = new ClientEntity();
        clientEntity1.setFirstName("Iqaluk");
        clientEntity1.setLastName("Guo");
        clientEntity1.setEmail("iqalukguo@email.com");

        ClientEntity clientEntity2 = new ClientEntity();
        clientEntity2.setFirstName("Francois");
        clientEntity2.setLastName("Arnaud");
        clientEntity2.setEmail("frarnaud@email.com");

        AdvisorEntity advisorEntity = new AdvisorEntity();
        advisorEntity.setFirstName("Frank");
        advisorEntity.setLastName("Advice");
        advisorEntity.setEmail("frankadvice@email.com");

        entityManager.persist(clientEntity1);
        entityManager.persist(clientEntity2);
        entityManager.persist(advisorEntity);

        clientEntity1.setAdvisorEntity(advisorEntity);
        clientEntity2.setAdvisorEntity(advisorEntity);

        entityManager.persist(clientEntity1);

        List<ClientEntity> results = clientRepository.findClientsByAdvisorId(advisorEntity.getId());
        assertThat(results.size()).isEqualTo(2);

    }
}
