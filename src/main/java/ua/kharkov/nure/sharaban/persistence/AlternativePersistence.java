package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Alternative;

public interface AlternativePersistence extends CrudRepository<Alternative, Long> {
}
