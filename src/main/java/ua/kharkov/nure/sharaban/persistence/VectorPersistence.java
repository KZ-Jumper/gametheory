package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Vector;

import java.util.List;

public interface VectorPersistence extends CrudRepository<Vector, Long> {

    @Query("from Vector v where v.alternative.id=?1")
    List<Vector> findByAlternativeId(long alternativeId);
}
