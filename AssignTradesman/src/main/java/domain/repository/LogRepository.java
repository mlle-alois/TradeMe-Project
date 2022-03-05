package domain.repository;

import kernel.Repository;
import  domain.Log;
import  domain.valueObjects.LogId;

import java.util.List;

public interface LogRepository extends Repository<LogId, Log> {
    List<Log> findAll();
}
