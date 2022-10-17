package io.darrion.clientmanager.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "clients")
public class ClientEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id")
    private AdvisorEntity advisorEntity;

    @PrePersist
    public void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
