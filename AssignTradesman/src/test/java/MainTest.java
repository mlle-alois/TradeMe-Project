import general.user_cases.assign_tradesman.application.RequestAssignTradesman;
import general.user_cases.assign_tradesman.application.RequestAssignTradesmanCommandHandler;
import general.user_cases.assign_tradesman.application.RequestAssignTradesmanEvent;
import general.user_cases.assign_tradesman.application.RequestAssignTradesmanEventListener;
import general.user_cases.assign_tradesman.domain.Company;
import general.user_cases.assign_tradesman.domain.Subscription;
import general.user_cases.assign_tradesman.domain.Tradesman;
import general.user_cases.assign_tradesman.domain.repository.MemberRepository;
//import general.user_cases.assign_tradesman.domain.repository.ProjectRepository;
import general.user_cases.assign_tradesman.domain.repository.ProjectRepository;
import general.user_cases.assign_tradesman.domain.valueObjects.*;
import general.user_cases.assign_tradesman.infrastructure.DefaultEventDispatcher;
import general.user_cases.assign_tradesman.infrastructure.InMemoryMemberRepository;
import general.user_cases.assign_tradesman.infrastructure.InMemoryProjectRepository;
import general.kernel.Event;
import general.kernel.EventListener;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MainTest {
    @Test
    public void testNewGameShouldReturnLoveAll() {

        MemberRepository memberRepository = new InMemoryMemberRepository();
        ProjectRepository projectRepository = new InMemoryProjectRepository();

        MemberId memberId = MemberId.of(1);
        memberRepository.add(Tradesman.of(memberId, MemberName.of("Aloïs"), Company.of("Sport 2000", CompanyId.of("EV2TS5000")), Subscription.of("annual")));


        Calendar startDate = Calendar.getInstance();
        startDate.set(2022, Calendar.JUNE, 15);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2022, Calendar.JUNE, 20);
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(RequestAssignTradesmanEvent.class, List.of(new RequestAssignTradesmanEventListener()));
        var eventDispatcher = new DefaultEventDispatcher(listenerMap);
        //--1. Create Project
      /*  RequestAssignTradesmanCommandHandler requestAssignTradesmanCommandHandler = new RequestAssignTradesmanCommandHandler(projectRepository,memberRepository,eventDispatcher);
        RequestAssignTradesman createProject = new RequestAssignTradesman("Plomberie magasin", memberId,  startDate, endDate, 5);
        requestAssignTradesmanCommandHandler.handle(createProject);*/

        //assertEquals("Plomberie magasin", projectRepository.findById(projectId).getProjectName());
    }




}
