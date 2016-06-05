package ua.kharkov.nure.sharaban.service;

import ua.kharkov.nure.sharaban.model.Vector;

import java.util.List;

public interface VectorService {

    List<Vector> getAllVectors();

    Vector getVectorById(long id);

    Vector saveOrUpdateVector(Vector vector);

    void deleteVector(long id);
}
