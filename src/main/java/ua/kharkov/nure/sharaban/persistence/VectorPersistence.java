package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Vector;

public interface VectorPersistence extends CrudRepository<Vector, Long> {
}
