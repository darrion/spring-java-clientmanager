package io.darrion.clientmanager.repo;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.entity.ClientEntity;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdvisorRepository advisorRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Test
    void testDoesExistByEmail() {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName("Iqaluk");
        clientEntity.setLastName("Guo");
        clientEntity.setEmail("iqalukguo@esmail.com");
        entityManager.persist(clientEntity);
        Boolean result = clientRepository.existsByEmail(clientEntity.getEmail());
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
        clientRepository.save(clientEntity);
        ClientEntity result = clientRepository.findByEmail(clientEntity.getEmail());
        assertThat(result.getEmail()).isEqualTo("iqalukguo@email.com");
    }

    @Test
    void getClientsByAdvisorId() {
        
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

        clientRepository.save(clientEntity1);
        clientRepository.save(clientEntity2);
        advisorRepository.save(advisorEntity);

        clientEntity1.setAdvisorEntity(advisorEntity);
        clientEntity2.setAdvisorEntity(advisorEntity);

        clientRepository.save(clientEntity1);

        List<ClientEntity> results = clientRepository.findClientsByAdvisorId(advisorEntity.getId());
        assertThat(results.size()).isEqualTo(2);

    }
}
