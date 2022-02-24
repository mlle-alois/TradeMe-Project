package general.user_cases.create_project.infrastructure;

import general.kernel.exception.NoSuchEntityException;
import general.kernel.exception.NoSuchPaymentException;
import general.user_cases.create_project.domain.Payment;
import general.user_cases.create_project.domain.PaymentId;
import general.user_cases.create_project.domain.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryPaymentRepository implements PaymentRepository {
    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<PaymentId, Payment> data = new ConcurrentHashMap<>();


    @Override
    public PaymentId nextIdentity() {
        return new PaymentId(count.incrementAndGet());
    }

    @Override
    public Payment findById(PaymentId id) throws NoSuchEntityException {
        final Payment payment = data.get(id);
        if (payment == null) {
            throw NoSuchPaymentException.withId(id);
        }
        return payment;
    }

    @Override
    public void add(Payment payment) {
        data.put(payment.id(), payment);
    }

    @Override
    public void delete(PaymentId id) {
        data.remove(id);
    }

    @Override
    public List<Payment> findAll() {
        return List.copyOf(data.values());
    }
}