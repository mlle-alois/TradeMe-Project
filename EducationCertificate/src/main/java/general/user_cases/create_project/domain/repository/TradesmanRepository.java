package general.user_cases.create_project.domain.repository;

import general.kernel.Repository;
import general.user_cases.create_project.domain.Tradesman;
import general.user_cases.create_project.domain.valueObjects.TradesmanId;

import java.util.List;

public interface TradesmanRepository extends Repository<TradesmanId, Tradesman> {
    List<Tradesman> findAll();
}
