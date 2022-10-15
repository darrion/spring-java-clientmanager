package io.darrion.clientmanager.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AdvisorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName; 

    @Column(name = "middle_name", nullable = false)
    private String middleName; 

    @Column(name = "last_name", nullable = false)
    private String lastName; 

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt; 

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "advisorEntity")
    private Set<SpecializationEntity> specializationEntities;

    @OneToMany(mappedBy = "clientEntity")
    private Set<ClientEntity> clientEntities;
}