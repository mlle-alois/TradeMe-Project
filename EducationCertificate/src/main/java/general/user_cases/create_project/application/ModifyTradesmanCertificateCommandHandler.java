package general.user_cases.create_project.application;

import general.kernel.CommandHandler;
import general.kernel.Event;
import general.kernel.EventDispatcher;
import general.user_cases.create_project.domain.Tradesman;
import general.user_cases.create_project.domain.repository.MemberRepository;
import general.user_cases.create_project.domain.repository.TradesmanRepository;
import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.valueObjects.TradesmanId;

public class ModifyTradesmanCertificateCommandHandler implements CommandHandler<ModifyTradesmanCertificate, Void> {

    private final TradesmanRepository tradesmanRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public ModifyTradesmanCertificateCommandHandler(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventDispatcher) {

        this.tradesmanRepository = tradesmanRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Void handle(ModifyTradesmanCertificate command) {
        TradesmanId tradesmanId =  command.tradesmanId;
        Tradesman tradesman = tradesmanRepository.findById(tradesmanId);
        tradesman.addCertificate(command.aptitudeCertificates);
        tradesmanRepository.add(tradesman);
        eventDispatcher.dispatch(new ModifyTradesmanCertificateEvent(tradesmanId));
        return null;
    }
}
