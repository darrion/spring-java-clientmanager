package io.darrion.clientmanager.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "clients")
public class ClientEntity extends UserEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id")
    private AdvisorEntity advisorEntity;

}
