package general.user_cases.assign_tradesman.domain.repository;

import general.kernel.Repository;
import  general.user_cases.assign_tradesman.domain.Log;
import  general.user_cases.assign_tradesman.domain.valueObjects.LogId;

import java.util.List;

public interface LogRepository extends Repository<LogId, Log> {
    List<Log> findAll();
}
