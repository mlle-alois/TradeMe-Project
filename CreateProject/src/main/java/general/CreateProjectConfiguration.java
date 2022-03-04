package general;

import general.kernel.*;
import general.user_cases.create_project.application.CreateProject;
import general.user_cases.create_project.application.CreateProjectCommandHandler;
import general.user_cases.create_project.application.CreateProjectEvent;
import general.user_cases.create_project.application.CreateProjectEventListener;
import general.user_cases.create_project.domain.repository.MemberRepository;
import general.user_cases.create_project.domain.repository.ProjectRepository;
import general.user_cases.create_project.infrastructure.DefaultEventDispatcher;
import general.user_cases.create_project.infrastructure.InMemoryMemberRepository;
import general.user_cases.create_project.infrastructure.InMemoryProjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class CreateProjectConfiguration {

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
        listenerMap.put(CreateProjectEvent.class, List.of(new CreateProjectEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateProjectCommandHandler createProjectCommandHandler() {
        return new CreateProjectCommandHandler(projectRepository(), memberRepository(), eventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreateProject.class, createProjectCommandHandler());
        return new SimpleCommandBus(commandHandlerMap);
    }


}
