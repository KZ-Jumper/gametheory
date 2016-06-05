package ua.kharkov.nure.sharaban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kharkov.nure.sharaban.model.Criterion;
import ua.kharkov.nure.sharaban.persistence.CriterionPersistence;
import ua.kharkov.nure.sharaban.service.CriterionService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CriterionServiceImpl implements CriterionService{

    @Autowired
    private CriterionPersistence criterionPersistence;

    @Override
    public List<Criterion> getAllCriteria() {
        return (List<Criterion>) criterionPersistence.findAll();
    }

    @Override
    public List<String> getAllCriteriaNames() {
        return criterionPersistence.findAllCriteriaNames();
    }

    @Override
    public Criterion getCriterionById(long id) {
        return criterionPersistence.findOne(id);
    }

    @Override
    public Criterion getCriterionByName(String name) {
        return criterionPersistence.findByName(name);
    }

    @Override
    @Transactional
    public Criterion saveOrUpdateCriterion(Criterion criterion) {
        return criterionPersistence.save(criterion);
    }

    @Override
    @Transactional
    public void deleteCriterion(long id) {
        criterionPersistence.delete(id);
    }
}
