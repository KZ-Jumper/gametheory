package ua.kharkov.nure.sharaban.service.normalization.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kharkov.nure.sharaban.model.Build;
import ua.kharkov.nure.sharaban.model.Criterion;
import ua.kharkov.nure.sharaban.model.Mark;
import ua.kharkov.nure.sharaban.persistence.AlternativePersistence;
import ua.kharkov.nure.sharaban.persistence.BuildPersistence;
import ua.kharkov.nure.sharaban.service.normalization.MarkNormalizationService;

import java.util.Map;

@Component
public class MarkNormalizationServiceImpl implements MarkNormalizationService {

	@Autowired
	private AlternativePersistence alternativePersistence;

	@Autowired
	private BuildPersistence buildPersistence;

	@Override
	public void doNormalization(long alternativeId, long criterionId, Mark mark) {
		Iterable<Build> alternativeCriterions = buildPersistence.findByAlternativeId(alternativeId);
		for(Build alternativeCriterion : alternativeCriterions) {
			if (alternativeCriterion.getCriterion().getId() == criterionId) {
				mark.setNormalizedMark(Math.abs(mark.getMarkNumberEquivalent() - alternativeCriterion.getValue()));
				break;
			}
		}
	}

	private Map.Entry<Criterion, Mark> findNormalizationEntryByCriterionId(long id,
	                                                                       Map<Criterion, Mark> normalizationUnit) {
		Map.Entry<Criterion, Mark> entryToReturn = null;
		for(Map.Entry<Criterion, Mark> entry: normalizationUnit.entrySet()) {
			if(entry.getKey().getId() == id) {
				entryToReturn = entry;
				break;
			}
		}
		return entryToReturn;
	}
}