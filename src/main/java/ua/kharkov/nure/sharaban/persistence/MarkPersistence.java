package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Mark;

public interface MarkPersistence extends CrudRepository<Mark, Long> {
}
