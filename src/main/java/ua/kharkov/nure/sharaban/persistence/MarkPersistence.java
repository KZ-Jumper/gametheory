package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.Mark;

import java.util.List;

public interface MarkPersistence extends CrudRepository<Mark, Long> {

    @Query(nativeQuery = true, value = "SELECT m.* FROM mark m, vector v WHERE m.id = v.markId AND v.alternativeId=?1 AND m.lprId=?2")
    List<Mark> findMarksByAlternativeIdAndUserId(long alternativeId, long userId);
}
