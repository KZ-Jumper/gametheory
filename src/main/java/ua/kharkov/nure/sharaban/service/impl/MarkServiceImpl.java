package ua.kharkov.nure.sharaban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kharkov.nure.sharaban.model.Mark;
import ua.kharkov.nure.sharaban.persistence.MarkPersistence;
import ua.kharkov.nure.sharaban.service.MarkService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkPersistence markPersistence;

    @Override
    public List<Mark> getAllMarks() {
        return (List<Mark>) markPersistence.findAll();
    }

    @Override
    public Mark getMarkById(long id) {
        return markPersistence.findOne(id);
    }

    @Override
    public List<Mark> findMarksByAlternativeIdAndUserId(long alternativeId, long userId) {
        return markPersistence.findMarksByAlternativeIdAndUserId(alternativeId, userId);
    }

    @Override
    @Transactional
    public Mark saveOrUpdateMark(Mark mark) {
        return markPersistence.save(mark);
    }

    @Override
    @Transactional
    public void deleteMark(long id) {
        markPersistence.delete(id);
    }
}
