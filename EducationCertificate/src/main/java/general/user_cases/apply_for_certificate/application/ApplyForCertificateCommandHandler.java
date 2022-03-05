package general.user_cases.apply_for_certificate.application;

import general.kernel.CommandHandler;
import general.kernel.Event;
import general.kernel.EventDispatcher;

public class ApplyForCertificateCommandHandler implements CommandHandler<ApplyForCertificate, Void> {

    public final EventDispatcher<Event> eventDispatcher;

    public ApplyForCertificateCommandHandler(EventDispatcher<Event> eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }


    @Override
    public Void handle(ApplyForCertificate command) {
        command.acceptApplication();
        eventDispatcher.dispatch(new ApplyForCertificateEvent(command.tradesman, command.aptitudeCertificates));
        return null;
    }
}
