package general;

import general.kernel.*;
import general.user_cases.create_project.application.ApplyForMembership;
import general.user_cases.create_project.application.ApplyForMembershipCommandHandler;
import general.user_cases.create_project.application.ApplyForMembershipEvent;
import general.user_cases.create_project.application.ApplyForMembershipEventListener;
import general.user_cases.create_project.domain.MemberRepository;
import general.user_cases.create_project.domain.PaymentRepository;
import general.user_cases.create_project.infrastructure.DefaultEventDispatcher;
import general.user_cases.create_project.infrastructure.InMemoryMemberRepository;
import general.user_cases.create_project.infrastructure.InMemoryPaymentRepository;
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
    public PaymentRepository paymentRepository() {
        return new InMemoryPaymentRepository();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ApplyForMembershipEvent.class, List.of(new ApplyForMembershipEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public ApplyForMembershipCommandHandler applyForMembershipCommandHandler() {
        return new ApplyForMembershipCommandHandler(memberRepository(), paymentRepository(), eventEventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(ApplyForMembership.class, new ApplyForMembershipCommandHandler(memberRepository(), paymentRepository(), eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }


}
