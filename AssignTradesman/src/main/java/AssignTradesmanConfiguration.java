import application.RequestAssignTradesman;
import application.RequestAssignTradesmanCommandHandler;
import application.RequestAssignTradesmanEvent;
import application.RequestAssignTradesmanEventListener;
import domain.repository.MemberRepository;
import domain.repository.ProjectRepository;
import infrastructure.DefaultEventDispatcher;
import infrastructure.InMemoryMemberRepository;
import infrastructure.InMemoryProjectRepository;
import kernel.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AssignTradesmanConfiguration {

    @Bean
    public MemberRepository memberRepository() {
        return new InMemoryMemberRepository();
    }

    @Bean
    public ProjectRepository projectRepository() {
        return new InMemoryProjectRepository();
    }

    @Bean
    public EventDispatcher<Event> eventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(RequestAssignTradesmanEvent.class, List.of(new RequestAssignTradesmanEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public RequestAssignTradesmanCommandHandler applyForMembershipCommandHandler() {
        return new RequestAssignTradesmanCommandHandler(projectRepository(), memberRepository(), eventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(RequestAssignTradesman.class, new RequestAssignTradesmanCommandHandler(projectRepository(), memberRepository(), eventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }


}
