package general;

import general.user_cases.create_project.application.CreateProject;
import general.user_cases.create_project.application.CreateProjectCommandHandler;
import general.user_cases.create_project.domain.Company;
import general.user_cases.create_project.domain.Contractor;
import general.user_cases.create_project.domain.Subscription;
import general.user_cases.create_project.domain.Task;
import general.user_cases.create_project.domain.enums.*;
import general.user_cases.create_project.domain.repository.MemberRepository;
import general.user_cases.create_project.domain.repository.ProjectRepository;
import general.user_cases.create_project.domain.valueObjects.*;
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
        memberRepository.add(Contractor.of(memberId, MemberName.of("Aloïs"), Company.of("Sport 2000", CompanyId.of("EV2TS5000")), Subscription.of("annual")));

        List<Task> tasks = new ArrayList<>() {{
            add(Task.of("Plomberie",
                    new ArrayList<>() {{
                        add(AptitudeCertificates.BEP_PLUMBER);
                    }},
                    new ArrayList<>() {{
                        add(Speciality.PLUMBER);
                    }},
                    new ArrayList<>() {{
                        add(Skills.ABILITY_TO_WORK_ALONE);
                        add(Skills.MANAGE_A_TEAM);
                    }},
                    5));
        }};

        Calendar startDate = Calendar.getInstance();
        startDate.set(2022, Calendar.JUNE, 15);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2022, Calendar.JUNE, 20);

        //--1. Create Project
        CreateProjectCommandHandler createProjectCommandHandler = applicationContext.getBean(CreateProjectCommandHandler.class);
        CreateProject createProject = new CreateProject("Plomberie magasin", memberId, tasks, startDate, endDate, Department.ESSONNE_91, DailyRate.of(85), 5);
        final ProjectId projectId = createProjectCommandHandler.handle(createProject);

        System.out.println(projectRepository.findById(projectId).toString());
    }
}
