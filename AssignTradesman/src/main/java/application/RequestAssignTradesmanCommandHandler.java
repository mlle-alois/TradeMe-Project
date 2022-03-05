package application;

import domain.Project;
import domain.Tradesman;
import kernel.CommandHandler;
import kernel.Event;
import kernel.EventDispatcher;
import domain.repository.MemberRepository;
import domain.repository.ProjectRepository;
import domain.valueObjects.ProjectId;

import java.util.Objects;

public final class RequestAssignTradesmanCommandHandler implements CommandHandler<RequestAssignTradesman, ProjectId> {

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;
    private final EventDispatcher<Event> eventDispatcher;

    public RequestAssignTradesmanCommandHandler(ProjectRepository projectRepository, MemberRepository memberRepository, EventDispatcher<Event> eventDispatcher) {
        this.projectRepository = Objects.requireNonNull(projectRepository);
        this.memberRepository = Objects.requireNonNull(memberRepository);
        this.eventDispatcher = Objects.requireNonNull(eventDispatcher);
    }

    public ProjectId handle(RequestAssignTradesman createProject) {
       final ProjectId projectId = projectRepository.nextIdentity();
        Project project = Project.emptyProject(projectId, createProject.projectName
               , createProject.startDate, createProject.endDate
                , createProject.durationOfEngagmentInDays);
        projectRepository.add(project);
        eventDispatcher.dispatch(new RequestAssignTradesmanEvent(projectId));
        return projectId;
    }
}
