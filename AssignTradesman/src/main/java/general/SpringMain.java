package general;

import general.kernel.CommandBus;
import general.user_cases.assign_tradesman.application.ApplyForProject;
import general.user_cases.assign_tradesman.domain.Company;
import general.user_cases.assign_tradesman.domain.Project;
import general.user_cases.assign_tradesman.domain.Subscription;
import general.user_cases.assign_tradesman.domain.Tradesman;
import general.user_cases.assign_tradesman.domain.repository.MemberRepository;
import general.user_cases.assign_tradesman.domain.repository.ProjectRepository;
import general.user_cases.assign_tradesman.domain.valueObjects.CompanyId;
import general.user_cases.assign_tradesman.domain.valueObjects.MemberId;
import general.user_cases.assign_tradesman.domain.valueObjects.MemberName;
import general.user_cases.assign_tradesman.domain.valueObjects.ProjectId;
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
        CommandBus commandBus = applicationContext.getBean(CommandBus.class);

        MemberId memberId = MemberId.of(1);
        memberRepository.add(Tradesman.of(memberId, MemberName.of("Ichaï"), Company.of("Sport 2000", CompanyId.of("EV2TS5000")), Subscription.of("annual")));



        Calendar startDate = Calendar.getInstance();
        startDate.set(2022, Calendar.JUNE, 15);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2022, Calendar.JUNE, 20);

        ProjectId projectId = ProjectId.of(1);
       Project project = Project.emptyProject( projectId,"Plomberie magasin", startDate, endDate);
        projectRepository.add(project);

        Tradesman tradesman = memberRepository.findById(memberId);
        tradesman.addProject(project);

        ProjectId projectIdNew = ProjectId.of(2);
        Calendar startDateNew = Calendar.getInstance();
        startDateNew.set(2022, Calendar.JUNE, 10);

        Calendar endDateNew = Calendar.getInstance();
        endDateNew.set(2022, Calendar.JUNE, 14);


        Project projectNew = Project.emptyProject( projectIdNew,"Maçonnerie magasin", startDateNew, endDateNew);
        projectRepository.add(projectNew);

        ApplyForProject applyForProject = new ApplyForProject(tradesman, projectNew);
        commandBus.send(applyForProject);

        //--1. Create Project
        /*        RequestAssignTradesmanCommandHandler requestAssignTradesmanCommandHandler = applicationContext.getBean(RequestAssignTradesmanCommandHandler.class);
        RequestAssignTradesman assignTradesman = new RequestAssignTradesman(projectId.getValue(),memberId.getValue());
         requestAssignTradesmanCommandHandler.handle(assignTradesman);*/

        System.out.println(memberRepository.findById(memberId).toString());
    }
}
