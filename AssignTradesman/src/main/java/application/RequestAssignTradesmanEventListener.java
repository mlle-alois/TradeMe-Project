package application;

import kernel.EventListener;

public final class RequestAssignTradesmanEventListener implements EventListener<RequestAssignTradesmanEvent> {
    @Override
    public void listenTo(RequestAssignTradesmanEvent event) {
        System.out.println("listening RequestAssignTradesmanEvent.");
        System.out.println("================================= Project was created, you can now complete it for his activation =================================");
    }
}
