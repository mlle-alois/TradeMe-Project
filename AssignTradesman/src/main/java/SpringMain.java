import application.RequestAssignTradesman;
import application.RequestAssignTradesmanCommandHandler;
import domain.Company;
import domain.Member;
import domain.Subscription;
import domain.Tradesman;
import domain.repository.MemberRepository;
import domain.repository.ProjectRepository;
import domain.valueObjects.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
public class
SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);

        MemberRepository memberRepository = applicationContext.getBean(MemberRepository.class);
        ProjectRepository projectRepository = applicationContext.getBean(ProjectRepository.class);

        MemberId memberId = MemberId.of(1);
        memberRepository.add(Tradesman.of(memberId, MemberName.of("Aloïs"), Company.of("Sport 2000", CompanyId.of("EV2TS5000")), Subscription.of("annual")));



        Calendar startDate = Calendar.getInstance();
        startDate.set(2022, Calendar.JUNE, 15);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2022, Calendar.JUNE, 20);

        //--1. Create Project
        RequestAssignTradesmanCommandHandler requestAssignTradesmanCommandHandler = applicationContext.getBean(RequestAssignTradesmanCommandHandler.class);
        RequestAssignTradesman createProject = new RequestAssignTradesman("Plomberie magasin", memberId, startDate, endDate, 5);
        final ProjectId projectId = requestAssignTradesmanCommandHandler.handle(createProject);

        System.out.println(projectRepository.findById(projectId).toString());
    }
}
