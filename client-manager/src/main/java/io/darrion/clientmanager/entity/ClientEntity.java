package io.darrion.clientmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "clients")
@NoArgsConstructor
@NamedNativeQuery(
        name = "ClientEntity.findByEmail",
        resultSetMapping = "clientResultMapping",
        resultClass = ClientEntity.class,
        query = "SELECT id, first_name, middle_name, last_name, email, created_at, updated_at FROM clients WHERE email=?1"
)
@SqlResultSetMapping(
        name="clientResultMapping",
        classes = @ConstructorResult(
                targetClass = ClientEntity.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "first_name", type = String.class),
                        @ColumnResult(name = "middle_name", type = String.class),
                        @ColumnResult(name = "last_name", type = String.class),
                        @ColumnResult(name = "email", type = String.class),
                        @ColumnResult(name = "created_at", type = java.util.Date.class),
                        @ColumnResult(name = "updated_at", type = java.util.Date.class)
                }))
public class ClientEntity extends UserEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id")
    private AdvisorEntity advisorEntity;

    public ClientEntity(Integer id,
                        String firstName,
                        String middleName,
                        String lastName,
                        String email,
                        java.util.Date createdAt,
                        java.util.Date updatedAt
    )
    {
        super(id, email, firstName, middleName, lastName, createdAt, updatedAt);
    }

}
