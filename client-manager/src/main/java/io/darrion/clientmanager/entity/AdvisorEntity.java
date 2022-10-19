package io.darrion.clientmanager.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name = "advisors")
public class AdvisorEntity extends UserEntity {
}

