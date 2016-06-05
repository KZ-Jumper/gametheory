package ua.kharkov.nure.sharaban.service;

import ua.kharkov.nure.sharaban.model.Alternative;
import ua.kharkov.nure.sharaban.model.Build;

import java.util.List;

public interface AlternativeService {

    List<Alternative> getAllAlternatives();

    List<Build> getBuildsByAlternativeId(long id);

    Build getBuildById(long id);

    Alternative getAlternativeById(long id);

    Alternative saveOrUpdateAlternative(Alternative alternative);

    Build saveOrUpdateBuild(Build build);

    void deleteAlternative(long id);
}
