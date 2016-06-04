package ua.kharkov.nure.sharaban.service;

import ua.kharkov.nure.sharaban.model.LPR;

import java.util.List;

public interface LPRService {

    List<LPR> getAllPeople();

    LPR getPersonById(long id);

    LPR getPersonByName(String name);

    LPR saveOrUpdatePerson(LPR person);

    void deletePerson(long id);
}
