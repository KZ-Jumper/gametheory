package ua.kharkov.nure.sharaban.service.normalization;

import ua.kharkov.nure.sharaban.model.Mark;

public interface MarkNormalizationService {
	void doNormalization(long alternativeId, long criterionId, Mark mark);
}
