package io.darrion.clientmanager.factory;

import io.darrion.clientmanager.entity.AdvisorEntity;
import io.darrion.clientmanager.model.Advisor;

public class UserFactory {

    private UserFactory() {}

    public static Advisor create(AdvisorEntity advisorEntity) {
        Advisor advisor = new Advisor();
        advisor.setId(advisorEntity.getId());
        advisor.setFirstName(advisorEntity.getFirstName());
        advisor.setMiddleName(advisorEntity.getMiddleName());
        advisor.setLastName(advisorEntity.getLastName());
        advisor.setCreatedAt(advisorEntity.getCreatedAt());
        advisor.setUpdatedAt(advisorEntity.getUpdatedAt());
        return advisor;
    }
}
