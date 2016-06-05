package ua.kharkov.nure.sharaban.service.normalization;

import ua.kharkov.nure.sharaban.model.Criterion;
import ua.kharkov.nure.sharaban.model.Mark;

import java.util.Map;

public interface MarkNormalizationService {
	void doNormalization(Map<Criterion, Mark> normalizationUnit, long alternativeId);
}
