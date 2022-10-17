package io.darrion.clientmanager.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@Entity(name = "advisors")
public class AdvisorEntity extends UserEntity {}

