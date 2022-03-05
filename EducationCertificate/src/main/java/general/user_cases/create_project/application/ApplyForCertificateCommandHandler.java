package general.user_cases.create_project.application;

import general.kernel.CommandHandler;
import general.kernel.Event;
import general.kernel.EventDispatcher;
import general.user_cases.create_project.domain.enums.AptitudeCertificates;

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
