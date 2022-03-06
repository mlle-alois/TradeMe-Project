package general.application;

import kernel.EventListener;

public class ApplyForProjectEventListener implements EventListener<ApplyForProjectEvent> {

    private final RequestAssignTradesmanCommandHandler RequestAssignTradesmanCommandHandler;

    public ApplyForProjectEventListener(RequestAssignTradesmanCommandHandler modifyTradesmanCertificateCommandHandler) {
        this.RequestAssignTradesmanCommandHandler = modifyTradesmanCertificateCommandHandler;
    }

    @Override
    public void listenTo(ApplyForProjectEvent event) {
        System.out.println("Applying for new Certificate");
        RequestAssignTradesman modifyTradesmanCertificate = new RequestAssignTradesman(event.project.getProjectId(),event.tradesman.id());
        RequestAssignTradesmanCommandHandler.handle(modifyTradesmanCertificate);
    }
}
