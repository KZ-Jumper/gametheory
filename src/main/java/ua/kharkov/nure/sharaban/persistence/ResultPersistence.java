package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Result;

import java.util.List;

public interface ResultPersistence extends CrudRepository<Result, Long> {

    @Query("from Result r where r.lpr.id=?1")
    List<Result> findByUserId(long id);
}
