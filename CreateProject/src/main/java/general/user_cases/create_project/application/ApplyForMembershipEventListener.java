package general.user_cases.create_project.application;

import general.kernel.EventListener;

public final class ApplyForMembershipEventListener implements EventListener<ApplyForMembershipEvent> {
    @Override
    public void listenTo(ApplyForMembershipEvent event) {
        System.out.println("ApplyForMembershipEvent");
    }
}
