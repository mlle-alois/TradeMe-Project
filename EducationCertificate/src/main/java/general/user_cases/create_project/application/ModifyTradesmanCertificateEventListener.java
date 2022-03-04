package general.user_cases.create_project.application;

import general.kernel.EventListener;

public class ModifyTradesmanCertificateEventListener implements EventListener<ModifyTradesmanCertificateEvent> {
    @Override
    public void listenTo(ModifyTradesmanCertificateEvent event) {
        System.out.println("Membership Modified");
    }
}
