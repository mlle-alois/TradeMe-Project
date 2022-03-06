package general;

import general.application.*;
import general.domain.repository.MemberRepository;
import general.domain.repository.ProjectRepository;
import general.infrastructure.DefaultEventDispatcher;
import general.infrastructure.InMemoryMemberRepository;
import general.infrastructure.InMemoryProjectRepository;
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
        listenerMap.put(ApplyForProjectEvent.class, List.of(new ApplyForProjectEventListener(requestAssignTradesmanCommandHandler())));
        return new DefaultEventDispatcher(listenerMap);
    }
    @Bean
    public RequestAssignTradesmanCommandHandler requestAssignTradesmanCommandHandler(){
        return new RequestAssignTradesmanCommandHandler(projectRepository(),memberRepository());
    }
    @Bean
    public ApplyForProjectCommandHandler applyForProjectCommandHandler(){
        return new ApplyForProjectCommandHandler(eventDispatcher());
    }


    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(ApplyForProject.class, applyForProjectCommandHandler());
        commandHandlerMap.put(RequestAssignTradesman.class, requestAssignTradesmanCommandHandler());
        return new SimpleCommandBus(commandHandlerMap);
    }


}
