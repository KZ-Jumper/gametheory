package ua.kharkov.nure.sharaban.persistence;

import org.springframework.data.repository.CrudRepository;
import ua.kharkov.nure.sharaban.model.LPR;

public interface LPRPersistence extends CrudRepository<LPR, Long> {

    LPR findByName(String name);
}
