package general.domain.repository;


import general.domain.Log;
import general.domain.valueObjects.LogId;
import kernel.Repository;

import java.util.List;

public interface LogRepository extends Repository<LogId, Log> {
    List<Log> findAll();
}
