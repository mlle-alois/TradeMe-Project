package general.user_cases.create_project.application;

import general.kernel.CommandHandler;
import general.kernel.Event;
import general.kernel.EventDispatcher;
import general.user_cases.create_project.domain.Contractor;
import general.user_cases.create_project.domain.Project;
import general.user_cases.create_project.domain.repository.MemberRepository;
import general.user_cases.create_project.domain.repository.ProjectRepository;
import general.user_cases.create_project.domain.valueObjects.ProjectId;

import java.util.Objects;

public final class CreateProjectCommandHandler implements CommandHandler<CreateProject, ProjectId> {

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public CreateProjectCommandHandler(ProjectRepository projectRepository, MemberRepository memberRepository, EventDispatcher<Event> eventDispatcher) {
        this.projectRepository = Objects.requireNonNull(projectRepository);
        this.memberRepository = Objects.requireNonNull(memberRepository);
        this.eventDispatcher = Objects.requireNonNull(eventDispatcher);
    }

    public ProjectId handle(CreateProject createProject) {
        final ProjectId projectId = projectRepository.nextIdentity();
        Project project = Project.emptyProject(projectId, createProject.projectName, 
                (Contractor) memberRepository.findById(createProject.responsible), 
                createProject.tasks, createProject.startDate, createProject.endDate,
                createProject.location, createProject.desiredDailyRate, createProject.durationOfEngagmentInDays);
        projectRepository.add(project);
        eventDispatcher.dispatch(new CreateProjectEvent(projectId));
        return projectId;
    }
}
