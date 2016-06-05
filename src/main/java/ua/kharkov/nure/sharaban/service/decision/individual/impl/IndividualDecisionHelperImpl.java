package ua.kharkov.nure.sharaban.service.decision.individual.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kharkov.nure.sharaban.model.Alternative;
import ua.kharkov.nure.sharaban.model.LPR;
import ua.kharkov.nure.sharaban.model.Mark;
import ua.kharkov.nure.sharaban.model.Result;
import ua.kharkov.nure.sharaban.persistence.AlternativePersistence;
import ua.kharkov.nure.sharaban.persistence.MarkPersistence;
import ua.kharkov.nure.sharaban.persistence.ResultPersistence;
import ua.kharkov.nure.sharaban.service.decision.individual.IndividualDecisionHelper;

@Component
public class IndividualDecisionHelperImpl implements IndividualDecisionHelper{

	@Autowired
	private AlternativePersistence alternativePersistence;

	@Autowired
	private MarkPersistence markPersistence;

	@Autowired
	private ResultPersistence resultPersistence;

	@Override
	public void makeDecision(LPR person) {
		Iterable<Alternative> alternatives = alternativePersistence.findAll();
		for(Alternative alternative : alternatives) {
			long id = alternative.getId();
			Iterable<Mark> marks = markPersistence.findMarksByAlternativeIdAndUserId(id, person.getId());

			int benefitCoefficient = calculateBenefitCoefficient(marks);
			saveResult(alternative, benefitCoefficient, person);
		}
	}

	private int calculateBenefitCoefficient(Iterable<Mark> marks) {
		int benefitCoefficient = 0;
		for(Mark mark : marks) {
			benefitCoefficient += mark.getRange() * mark.getNormalizedMark();
		}
		return benefitCoefficient;
	}

	private void saveResult(Alternative alternative, int benefitCoefficient, LPR person) {
		Result result = new Result();
		result.setAlternative(alternative);
		result.setRange(benefitCoefficient);
		result.setLpr(person);
		resultPersistence.save(result);
	}
}
