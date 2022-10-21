package io.darrion.clientmanager.repo;

import io.darrion.clientmanager.entity.ClientEntity;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void testDoesExistByEmail() {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName("Iqaluk");
        clientEntity.setLastName("Guo");
        clientEntity.setEmail("iqalukguo@gmail.com");
        entityManager.persist(clientEntity);
        Boolean result = clientRepository.existsByEmail(clientEntity.getEmail());
        assertThat(result).isTrue();
    }

    @Test 
    void testDoesNotExistByEmail() {
        Boolean result = clientRepository.existsByEmail("iqalukguo@gmail.com");
        assertThat(result).isFalse();
    }

    @Test
    void testGetByEmail() {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setFirstName("Iqaluk");
        clientEntity.setLastName("Guo");
        clientEntity.setEmail("iqalukguo@gmail.com");
        clientRepository.save(clientEntity);
        ClientEntity result = clientRepository.findByEmail(clientEntity.getEmail());
        assertThat(result.getEmail()).isEqualTo("iqalukguo@gmail.com");
    }
}
