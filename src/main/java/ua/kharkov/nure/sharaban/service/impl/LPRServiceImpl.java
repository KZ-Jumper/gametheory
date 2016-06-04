package ua.kharkov.nure.sharaban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.nure.sharaban.model.LPR;
import ua.kharkov.nure.sharaban.persistence.LPRPersistence;
import ua.kharkov.nure.sharaban.service.LPRService;

import java.util.List;

@Service
public class LPRServiceImpl implements LPRService {

    @Autowired
    private LPRPersistence lprPersistence;

    public List<LPR> getAllPeople() {
        return (List<LPR>) lprPersistence.findAll();
    }

    public LPR getPersonById(long id) {
        return lprPersistence.findOne(id);
    }

    public LPR getPersonByName(String name) {
        return lprPersistence.findByName(name);
    }

    public LPR saveOrUpdatePerson(LPR person) {
        return lprPersistence.save(person);
    }

    public void deletePerson(long id) {
        lprPersistence.delete(id);
    }
}
