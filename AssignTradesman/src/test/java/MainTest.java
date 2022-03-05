import application.RequestAssignTradesman;
import application.RequestAssignTradesmanCommandHandler;
import application.RequestAssignTradesmanEvent;
import application.RequestAssignTradesmanEventListener;
import domain.Company;
import domain.Subscription;
import domain.Tradesman;
import domain.repository.MemberRepository;
//import domain.repository.ProjectRepository;
import domain.repository.ProjectRepository;
import domain.valueObjects.*;
import infrastructure.DefaultEventDispatcher;
import infrastructure.InMemoryMemberRepository;
import infrastructure.InMemoryProjectRepository;
import kernel.Event;
import kernel.EventListener;
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
        RequestAssignTradesmanCommandHandler requestAssignTradesmanCommandHandler = new RequestAssignTradesmanCommandHandler(projectRepository,memberRepository,eventDispatcher);
        RequestAssignTradesman createProject = new RequestAssignTradesman("Plomberie magasin", memberId,  startDate, endDate, 5);
        final ProjectId projectId = requestAssignTradesmanCommandHandler.handle(createProject);

        assertEquals("Plomberie magasin", projectRepository.findById(projectId).getProjectName());
    }




}
