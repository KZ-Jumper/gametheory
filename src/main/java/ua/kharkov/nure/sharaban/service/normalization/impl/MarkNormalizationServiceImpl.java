package ua.kharkov.nure.sharaban.service.normalization.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kharkov.nure.sharaban.model.Alternative;
import ua.kharkov.nure.sharaban.model.Build;
import ua.kharkov.nure.sharaban.model.Criterion;
import ua.kharkov.nure.sharaban.model.Mark;
import ua.kharkov.nure.sharaban.persistence.AlternativePersistence;
import ua.kharkov.nure.sharaban.persistence.BuildPersistence;
import ua.kharkov.nure.sharaban.service.normalization.MarkNormalizationService;

import java.util.Map;

public class MarkNormalizationServiceImpl implements MarkNormalizationService {
	@Autowired
	private AlternativePersistence alternativePersistence;

	@Autowired
	private BuildPersistence buildPersistence;

	@Override
	public void doNormalization(Map<Criterion, Mark> normalizationUnit, long alternativesId) {
		Iterable<Build> buildIterable = buildPersistence.findByAlternativeId(alternativesId);

		int normalizedValue;
		for(Build build : buildIterable) {
			Map.Entry<Criterion, Mark> currentCriterionEntry =
				findNormalizationEntryByCriterionId(build.getCriterion().getId(), normalizationUnit);

			int alternativeCriterionValue = build.getValue();
			int userCriterionValue = currentCriterionEntry.getValue().getMarkNumberEquivalent();

			normalizedValue = Math.abs(alternativeCriterionValue - userCriterionValue);

			Mark updatedMark = currentCriterionEntry.getValue();
			updatedMark.setNormalizedMark(normalizedValue);
			normalizationUnit.put(currentCriterionEntry.getKey(), updatedMark);
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