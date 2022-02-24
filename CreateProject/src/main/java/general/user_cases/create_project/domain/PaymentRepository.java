package general.user_cases.create_project.domain;

import general.kernel.Repository;

import java.util.List;

public interface PaymentRepository extends Repository<PaymentId, Payment> {
    List<Payment> findAll();
}
