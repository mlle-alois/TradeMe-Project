package general;

import general.user_cases.create_project.application.CreateProject;
import general.user_cases.create_project.application.CreateProjectCommandHandler;
import general.user_cases.create_project.domain.Company;
import general.user_cases.create_project.domain.Contractor;
import general.user_cases.create_project.domain.Subscription;
import general.user_cases.create_project.domain.enums.MemberShipType;
import general.user_cases.create_project.domain.repository.MemberRepository;
import general.user_cases.create_project.domain.valueObjects.CompanyId;
import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.valueObjects.MemberName;
import general.user_cases.create_project.domain.valueObjects.ProjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class 
SpringMain {
    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);
        
        MemberRepository memberRepository = applicationContext.getBean(MemberRepository.class);
        
        MemberId memberId = MemberId.of(1);
        memberRepository.add(Contractor.of(memberId, MemberName.of("Aloïs"), Company.of("Sport 2000", CompanyId.of("EV2TS5000")), Subscription.of("annual")));

        //--1. Create Project
        CreateProjectCommandHandler createProjectCommandHandler = applicationContext.getBean(CreateProjectCommandHandler.class);
        CreateProject createProject = new CreateProject("Rénovation vieille maison", memberId);
        final ProjectId projectId = createProjectCommandHandler.handle(createProject);
    }
}
