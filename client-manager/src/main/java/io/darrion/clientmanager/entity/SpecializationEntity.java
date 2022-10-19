package io.darrion.clientmanager.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "specializations")
public class SpecializationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "focus", nullable = false) 
    private String focus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", referencedColumnName = "id")
    private AdvisorEntity advisorEntity;
}
