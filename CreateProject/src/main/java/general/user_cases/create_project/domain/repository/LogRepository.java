package general.user_cases.create_project.domain.repository;

import general.kernel.Repository;
import general.user_cases.create_project.domain.Log;
import general.user_cases.create_project.domain.valueObjects.LogId;

import java.util.List;

public interface LogRepository extends Repository<LogId, Log> {
    List<Log> findAll();
}
