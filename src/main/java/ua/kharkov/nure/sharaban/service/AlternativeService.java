package ua.kharkov.nure.sharaban.service;

import ua.kharkov.nure.sharaban.model.Alternative;

import java.util.List;

public interface AlternativeService {

    List<Alternative> getAllAlternatives();

    Alternative getAlternativeById(long id);

    Alternative saveOrUpdateAlternative(Alternative alternative);

    void deleteAlternative(long id);
}
