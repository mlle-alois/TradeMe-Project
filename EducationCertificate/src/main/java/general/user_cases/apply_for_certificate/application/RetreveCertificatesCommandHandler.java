package general.user_cases.apply_for_certificate.application;

import general.kernel.QueryHandler;
import general.user_cases.apply_for_certificate.domain.Tradesman;
import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;
import general.user_cases.apply_for_certificate.domain.repository.TradesmanRepository;

import java.util.List;

public class RetreveCertificatesCommandHandler implements QueryHandler<RetreveCertificates, List<AptitudeCertificates>> {

    private final TradesmanRepository tradesmanRepository;

    public RetreveCertificatesCommandHandler(TradesmanRepository tradesmanRepository) {
        this.tradesmanRepository = tradesmanRepository;
    }

    @Override
    public List<AptitudeCertificates> handle(RetreveCertificates query) {
        Tradesman tradesman = tradesmanRepository.findById(query.tradesmanId);
        return tradesman.getAptitudeCertificates();
    }
}
