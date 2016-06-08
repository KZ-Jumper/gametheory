package ua.kharkov.nure.sharaban.service;

import ua.kharkov.nure.sharaban.model.Result;

import java.util.List;

public interface ResultService {

    List<Result> getAllResults();

    Result getResultById(long id);

    List<Result> getResultByUserId(long userId);

    Result saveOrUpdateResult(Result result);

    void deleteResult(long id);

    Result findByAlternativeIdAndUserId(long alternativeId, long userId);
}
