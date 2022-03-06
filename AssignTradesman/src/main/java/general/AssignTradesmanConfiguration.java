package general;


import general.kernel.*;
import general.user_cases.assign_tradesman.application.*;
import general.user_cases.assign_tradesman.domain.repository.MemberRepository;
import general.user_cases.assign_tradesman.domain.repository.ProjectRepository;
import general.user_cases.assign_tradesman.infrastructure.DefaultEventDispatcher;
import general.user_cases.assign_tradesman.infrastructure.InMemoryMemberRepository;
import general.user_cases.assign_tradesman.infrastructure.InMemoryProjectRepository;
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
