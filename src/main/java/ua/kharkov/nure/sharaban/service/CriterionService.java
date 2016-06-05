package ua.kharkov.nure.sharaban.service;

import ua.kharkov.nure.sharaban.model.Criterion;

import java.util.List;

public interface CriterionService {

    List<Criterion> getAllCriteria();

    List<String> getAllCriteriaNames();

    Criterion getCriterionById(long id);

    Criterion getCriterionByName(String name);

    Criterion saveOrUpdateCriterion(Criterion criterion);

    void deleteCriterion(long id);
}
