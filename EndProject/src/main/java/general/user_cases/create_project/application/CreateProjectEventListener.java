package general.user_cases.create_project.application;

import general.kernel.EventListener;

public final class CreateProjectEventListener implements EventListener<CreateProjectEvent> {
    @Override
    public void listenTo(CreateProjectEvent event) {
        System.out.println("listening CreateProjectEvent.");
        System.out.println("================================= Project was created, you can now complete it for his activation =================================");
    }
}
