package ua.kharkov.nure.sharaban.service;

import ua.kharkov.nure.sharaban.model.Criterion;

import java.util.List;

public interface CriterionService {

    List<Criterion> getAllCriteria();

    Criterion getCriterionById(long id);

    Criterion saveOrUpdateCriterion(Criterion criterion);

    void deleteCriterion(long id);
}
