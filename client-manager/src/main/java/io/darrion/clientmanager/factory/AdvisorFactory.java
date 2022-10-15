package io.darrion.clientmanager.factory;

import io.darrion.clientmanager.model.AdvisorModel;
import io.darrion.clientmanager.table.AdvisorTable;

public class AdvisorFactory {

    private AdvisorFactory() {}

    public static AdvisorModel create(AdvisorTable advisorTable) {
        AdvisorModel advisorModel = new AdvisorModel();
        advisorModel.setId(advisorTable.getId());
        advisorModel.setFirstName(advisorTable.getFirstName());
        advisorModel.setMiddleName(advisorTable.getMiddleName());
        advisorModel.setLastName(advisorTable.getLastName());
        advisorModel.setCreatedAt(advisorTable.getCreatedAt());
        advisorModel.setUpdatedAt(advisorTable.getUpdatedAt());
        return advisorModel;
    }
}
