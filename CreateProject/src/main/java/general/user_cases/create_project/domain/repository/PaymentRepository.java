package general.user_cases.create_project.domain.repository;

import general.kernel.Repository;
import general.user_cases.create_project.domain.Payment;
import general.user_cases.create_project.domain.valueObjects.PaymentId;

import java.util.List;

public interface PaymentRepository extends Repository<PaymentId, Payment> {
    List<Payment> findAll();
}
