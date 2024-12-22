package com.example.clientmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.NamedNativeQuery;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;

import com.example.clientmanager.constants.Name;
import com.example.clientmanager.constants.Query;
import com.example.clientmanager.constants.Column;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "advisors")
@NamedNativeQuery(
  name = "AdvisorEntity.findByEmail",
  resultSetMapping = Name.ADVISOR_MAPPING,
  resultClass = AdvisorEntity.class,
  query = Query.FIND_ADVISOR_BY_EMAIL
)
@SqlResultSetMapping(
  name = Name.ADVISOR_MAPPING,
  classes = @ConstructorResult(
    targetClass = AdvisorEntity.class,
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
@AllArgsConstructor
public class AdvisorEntity extends UserEntity {

    public AdvisorEntity(
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

