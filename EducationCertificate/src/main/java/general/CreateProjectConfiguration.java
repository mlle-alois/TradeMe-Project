package general;

import general.kernel.*;
import general.user_cases.create_project.application.*;
import general.user_cases.create_project.domain.repository.MemberRepository;
import general.user_cases.create_project.domain.repository.ProjectRepository;
import general.user_cases.create_project.domain.repository.TradesmanRepository;
import general.user_cases.create_project.infrastructure.DefaultEventDispatcher;
import general.user_cases.create_project.infrastructure.InMemoryMemberRepository;
import general.user_cases.create_project.infrastructure.InMemoryProjectRepository;
import general.user_cases.create_project.infrastructure.InMemoryTradesmanRepository;
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
    public TradesmanRepository tradesmanRepository(){
        return new InMemoryTradesmanRepository();
    }

    @Bean
    public ModifyTradesmanCertificateCommandHandler modifyTradesmanCertificateCommandHandler(){
        return new ModifyTradesmanCertificateCommandHandler(tradesmanRepository());
    }

    @Bean
    public RetreveCertificatesCommandHandler retreveCertificatesCommandHandler(){
        return new RetreveCertificatesCommandHandler(tradesmanRepository());
    }

    @Bean
    public EventDispatcher<Event> eventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ApplyForCertificateEvent.class, List.of(new ApplyForCertificateEventListener(modifyTradesmanCertificateCommandHandler())));
        return new DefaultEventDispatcher(listenerMap);
    }




    @Bean
    public ApplyForCertificateCommandHandler applyForCertificateCommandHandler(){
        return new ApplyForCertificateCommandHandler(eventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(ModifyTradesmanCertificate.class, modifyTradesmanCertificateCommandHandler());
        commandHandlerMap.put(ApplyForCertificate.class, applyForCertificateCommandHandler());
        return new SimpleCommandBus(commandHandlerMap);
    }


}
