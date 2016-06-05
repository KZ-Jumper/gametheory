package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Build;

import java.util.List;

public interface BuildPersistence extends CrudRepository<Build, Long> {

    List<Build> findByAlternativeId(long id);

    @Query("delete from Build b where b.alternative.id=?1")
    @Modifying
    void deleteByAlternativeId(long id);
}
