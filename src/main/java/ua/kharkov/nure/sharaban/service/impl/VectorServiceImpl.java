package ua.kharkov.nure.sharaban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kharkov.nure.sharaban.model.Vector;
import ua.kharkov.nure.sharaban.persistence.VectorPersistence;
import ua.kharkov.nure.sharaban.service.VectorService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class VectorServiceImpl implements VectorService {

    @Autowired
    private VectorPersistence vectorPersistence;

    @Override
    public List<Vector> getAllVectors() {
        return (List<Vector>) vectorPersistence.findAll();
    }

    @Override
    public Vector getVectorById(long id) {
        return vectorPersistence.findOne(id);
    }

    @Override
    public List<Vector> findByAlternativeId(long alternativeId) {
        return vectorPersistence.findByAlternativeId(alternativeId);
    }

    @Override
    @Transactional
    public Vector saveOrUpdateVector(Vector vector) {
        return vectorPersistence.save(vector);
    }

    @Override
    @Transactional
    public void deleteVector(long id) {
        vectorPersistence.delete(id);
    }
}
