package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Criterion;

public interface CriterionPersistence extends CrudRepository<Criterion, Long> {
}
