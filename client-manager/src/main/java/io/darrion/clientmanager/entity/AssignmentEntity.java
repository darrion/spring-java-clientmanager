package io.darrion.clientmanager.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.darrion.clientmanager.entity.composite.AssignmentId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter 
@Setter
@Entity(name = "assignment")
public class AssignmentEntity {
    
    @EmbeddedId
    AssignmentId id; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_advisor")
    private AdvisorEntity advisorEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_client")
    private ClientEntity clientEntity;
}
