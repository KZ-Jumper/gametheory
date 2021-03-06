package ua.kharkov.nure.sharaban.service;

import ua.kharkov.nure.sharaban.model.Mark;

import java.util.List;

public interface MarkService {

    List<Mark> getAllMarks();

    Mark getMarkById(long id);

    List<Mark> findMarksByAlternativeIdAndUserId(long alternativeId, long userId);

    Mark saveOrUpdateMark(Mark mark);

    void deleteMark(long id);
}
