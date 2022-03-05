package general.user_cases.create_project.application;

import general.kernel.EventListener;

public class ApplyForCertificateEventListener implements EventListener<ApplyForCertificateEvent> {

    private final ModifyTradesmanCertificateCommandHandler modifyTradesmanCertificateCommandHandler;

    public ApplyForCertificateEventListener(ModifyTradesmanCertificateCommandHandler modifyTradesmanCertificateCommandHandler) {
        this.modifyTradesmanCertificateCommandHandler = modifyTradesmanCertificateCommandHandler;
    }

    @Override
    public void listenTo(ApplyForCertificateEvent event) {
        System.out.println("Applying for new Certificate");
        ModifyTradesmanCertificate modifyTradesmanCertificate = new ModifyTradesmanCertificate(event.tradesman.id(), event.aptitudeCertificates);
        modifyTradesmanCertificateCommandHandler.handle(modifyTradesmanCertificate);
    }
}
