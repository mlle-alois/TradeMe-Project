package general.user_cases.assign_tradesman.application;

import general.kernel.CommandHandler;
import general.kernel.Event;
import general.kernel.EventDispatcher;

public class ApplyForProjectCommandHandler implements CommandHandler<ApplyForProject, Void> {

    public final EventDispatcher<Event> eventDispatcher;

    public ApplyForProjectCommandHandler(EventDispatcher<Event> eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }


    @Override
    public Void handle(ApplyForProject command) {
        if(command.IsTrademanAvailable()) {
            eventDispatcher.dispatch(new ApplyForProjectEvent(command.tradesman, command.project));
            return null;
        }
        return null;
    }
}
