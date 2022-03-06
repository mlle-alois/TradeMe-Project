package general.application;


import kernel.CommandHandler;
import kernel.Event;
import kernel.EventDispatcher;

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
