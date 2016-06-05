package ua.kharkov.nure.sharaban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kharkov.nure.sharaban.model.LPR;
import ua.kharkov.nure.sharaban.persistence.LPRPersistence;
import ua.kharkov.nure.sharaban.service.LPRService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LPRServiceImpl implements LPRService {

    @Autowired
    private LPRPersistence lprPersistence;

    @Override
    public List<LPR> getAllPeople() {
        return (List<LPR>) lprPersistence.findAll();
    }

    @Override
    public LPR getPersonById(long id) {
        return lprPersistence.findOne(id);
    }

    @Override
    public LPR getPersonByName(String name) {
        return lprPersistence.findByName(name);
    }

    @Override
    @Transactional
    public LPR saveOrUpdatePerson(LPR person) {
        return lprPersistence.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(long id) {
        lprPersistence.delete(id);
    }
}
