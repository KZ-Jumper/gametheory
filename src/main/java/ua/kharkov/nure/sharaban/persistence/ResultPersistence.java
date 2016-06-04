package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Result;

public interface ResultPersistence extends CrudRepository<Result, Long> {
}
