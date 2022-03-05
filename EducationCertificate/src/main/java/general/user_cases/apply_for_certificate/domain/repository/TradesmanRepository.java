package general.user_cases.apply_for_certificate.domain.repository;

import general.kernel.Repository;
import general.user_cases.apply_for_certificate.domain.Tradesman;
import general.user_cases.apply_for_certificate.domain.valueObjects.TradesmanId;

import java.util.List;

public interface TradesmanRepository extends Repository<TradesmanId, Tradesman> {
    List<Tradesman> findAll();
}
