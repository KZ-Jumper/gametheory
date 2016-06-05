package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Criterion;

import java.util.List;

public interface CriterionPersistence extends CrudRepository<Criterion, Long> {

    @Query("select c.name from Criterion c")
    List<String> findAllCriteriaNames();

    @Query("from Criterion c where c.name=?1")
    Criterion findByName(String name);
}
