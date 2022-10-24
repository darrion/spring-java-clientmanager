package io.darrion.clientmanager.entity;

import javax.persistence.*;

import io.darrion.clientmanager.constants.Query;
import io.darrion.clientmanager.constants.Column;
import io.darrion.clientmanager.constants.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "clients")
@NoArgsConstructor
@NamedNativeQuery(
  name = "ClientEntity.findByEmail",
  resultSetMapping = Name.CLIENT_MAPPING,
  resultClass = ClientEntity.class,
  query = Query.FIND_CLIENT_BY_EMAIL
)
@NamedNativeQuery(
        name = "ClientEntity.findClientsByAdvisorId", 
        resultSetMapping = Name.CLIENT_MAPPING,
        resultClass = ClientEntity.class, 
        query = Query.FIND_CLIENTS_BY_ADVISOR_ID
)
@SqlResultSetMapping(
  name = Name.CLIENT_MAPPING,
  classes = @ConstructorResult(
    targetClass = ClientEntity.class,
    columns = {
      @ColumnResult(name = Column.ID, type = Integer.class),
      @ColumnResult(name = Column.FIRST_NAME, type = String.class),
      @ColumnResult(name = Column.MIDDLE_NAME, type = String.class),
      @ColumnResult(name = Column.LAST_NAME, type = String.class),
      @ColumnResult(name = Column.EMAIL, type = String.class),
      @ColumnResult(name = Column.CREATED_AT, type = java.util.Date.class),
      @ColumnResult(name = Column.UPDATED_AT, type = java.util.Date.class),
    }
  )
)
public class ClientEntity extends UserEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "advisor_id")
  private AdvisorEntity advisorEntity;

  public ClientEntity(
    Integer id,
    String firstName,
    String middleName,
    String lastName,
    String email,
    java.util.Date createdAt,
    java.util.Date updatedAt
  ) {
    super(id, firstName, middleName, lastName, email, createdAt, updatedAt);
  }
}
