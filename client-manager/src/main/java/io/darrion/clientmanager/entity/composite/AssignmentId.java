package io.darrion.clientmanager.entity.composite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AssignmentId implements Serializable {

    @Column(name = "advisor_id")
    Integer advisorId;
    @Column(name = "client_id")
    Integer clientId; 
}
