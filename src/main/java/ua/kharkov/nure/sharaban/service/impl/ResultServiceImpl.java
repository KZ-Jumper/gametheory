package ua.kharkov.nure.sharaban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kharkov.nure.sharaban.model.Result;
import ua.kharkov.nure.sharaban.persistence.ResultPersistence;
import ua.kharkov.nure.sharaban.service.ResultService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultPersistence resultPersistence;

    @Override
    public List<Result> getAllResults() {
        return (List<Result>) resultPersistence.findAll();
    }

    @Override
    public Result getResultById(long id) {
        return resultPersistence.findOne(id);
    }

    @Override
    public List<Result> getResultByUserId(long userId) {
        return resultPersistence.findByUserId(userId);
    }

    @Override
    public Result findByAlternativeIdAndUserId(long alternativeId, long userId) {
        return resultPersistence.findByAlternativeIdAndUserId(alternativeId, userId);
    }

    @Override
    @Transactional
    public Result saveOrUpdateResult(Result result) {
        return resultPersistence.save(result);
    }

    @Override
    @Transactional
    public void deleteResult(long id) {
        resultPersistence.delete(id);
    }
}
