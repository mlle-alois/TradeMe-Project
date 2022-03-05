import application.RequestAssignTradesman;
import application.RequestAssignTradesmanCommandHandler;
import domain.*;
import domain.repository.MemberRepository;
import domain.repository.ProjectRepository;
import domain.valueObjects.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Calendar;


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

        ProjectId projectId = ProjectId.of(1);
       Project project = Project.emptyProject( projectId,"Plomberie magasin", startDate, endDate, 5);
        projectRepository.add(project);

        //--1. Create Project
        RequestAssignTradesmanCommandHandler requestAssignTradesmanCommandHandler = applicationContext.getBean(RequestAssignTradesmanCommandHandler.class);
        RequestAssignTradesman createProject = new RequestAssignTradesman(project,memberId);
        final ProjectId projectId = requestAssignTradesmanCommandHandler.handle(createProject);

        System.out.println(projectRepository.findById(projectId).toString());
    }
}
