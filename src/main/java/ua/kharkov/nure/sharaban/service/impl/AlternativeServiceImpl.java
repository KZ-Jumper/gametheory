package ua.kharkov.nure.sharaban.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.kharkov.nure.sharaban.model.Alternative;
import ua.kharkov.nure.sharaban.model.Build;
import ua.kharkov.nure.sharaban.persistence.AlternativePersistence;
import ua.kharkov.nure.sharaban.persistence.BuildPersistence;
import ua.kharkov.nure.sharaban.service.AlternativeService;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AlternativeServiceImpl implements AlternativeService {

    @Autowired
    private AlternativePersistence alternativePersistence;

    @Autowired
    private BuildPersistence buildPersistence;

    @Override
    public List<Alternative> getAllAlternatives() {
        return (List<Alternative>) alternativePersistence.findAll();
    }

    @Override
    public List<Build> getBuildsByAlternativeId(long id) {
        return buildPersistence.findByAlternativeId(id);
    }

    @Override
    public Build getBuildById(long id) {
        return buildPersistence.findOne(id);
    }

    @Override
    public Alternative getAlternativeById(long id) {
        return alternativePersistence.findOne(id);
    }

    @Override
    @Transactional
    public Alternative saveOrUpdateAlternative(Alternative alternative) {
        return alternativePersistence.save(alternative);
    }

    @Override
    @Transactional
    public Build saveOrUpdateBuild(Build build) {
        return buildPersistence.save(build);
    }

    @Override
    @Transactional
    public void deleteAlternative(long id) {
        buildPersistence.deleteByAlternativeId(id);
        alternativePersistence.delete(id);
    }
}
