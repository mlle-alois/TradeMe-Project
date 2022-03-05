package general.user_cases.apply_for_certificate.domain.repository;

import general.kernel.Repository;
import general.user_cases.apply_for_certificate.domain.Log;
import general.user_cases.apply_for_certificate.domain.valueObjects.LogId;

import java.util.List;

public interface LogRepository extends Repository<LogId, Log> {
    List<Log> findAll();
}
