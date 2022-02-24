package general.user_cases.create_project.domain;

import general.kernel.Repository;

import java.util.List;

public interface LogRepository extends Repository<LogId,Log> {
    List<Log> findAll();
}
