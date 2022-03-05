package general.user_cases.apply_for_certificate.application;

import general.kernel.CommandHandler;
import general.user_cases.apply_for_certificate.domain.Tradesman;
import general.user_cases.apply_for_certificate.domain.repository.TradesmanRepository;
import general.user_cases.apply_for_certificate.domain.valueObjects.TradesmanId;

public class ModifyTradesmanCertificateCommandHandler implements CommandHandler<ModifyTradesmanCertificate, Void> {

    private final TradesmanRepository tradesmanRepository;

    public ModifyTradesmanCertificateCommandHandler(TradesmanRepository tradesmanRepository) {

        this.tradesmanRepository = tradesmanRepository;
    }

    @Override
    public Void handle(ModifyTradesmanCertificate command) {
        TradesmanId tradesmanId =  command.tradesmanId;
        Tradesman tradesman = tradesmanRepository.findById(tradesmanId);
        tradesman.addCertificate(command.aptitudeCertificates);
        tradesmanRepository.add(tradesman);
        return null;
    }
}
