package general.user_cases.create_project.application;

import general.kernel.QueryHandler;
import general.user_cases.create_project.domain.Tradesman;
import general.user_cases.create_project.domain.enums.AptitudeCertificates;
import general.user_cases.create_project.domain.repository.TradesmanRepository;
import general.user_cases.create_project.domain.valueObjects.TradesmanId;

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
