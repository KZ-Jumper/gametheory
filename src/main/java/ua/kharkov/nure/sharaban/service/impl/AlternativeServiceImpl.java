package ua.kharkov.nure.sharaban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kharkov.nure.sharaban.model.Alternative;
import ua.kharkov.nure.sharaban.persistence.AlternativePersistence;
import ua.kharkov.nure.sharaban.service.AlternativeService;

import java.util.List;

@Service
public class AlternativeServiceImpl implements AlternativeService {

    @Autowired
    private AlternativePersistence alternativePersistence;

    public List<Alternative> getAllAlternatives() {
        return null;
    }

    public Alternative getAlternativeById(long id) {
        return null;
    }

    public Alternative saveOrUpdateAlternative(Alternative alternative) {
        return null;
    }

    public void deleteAlternative(long id) {

    }
}
