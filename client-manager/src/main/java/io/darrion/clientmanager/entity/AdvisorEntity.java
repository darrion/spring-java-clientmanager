package io.darrion.clientmanager.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "advisor")
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

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "advisor_id")
    private Set<SpecializationEntity> specializationEntities;

    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "client_id")
    private Set<ClientEntity> clientEntities;

    @PrePersist
    public void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}

