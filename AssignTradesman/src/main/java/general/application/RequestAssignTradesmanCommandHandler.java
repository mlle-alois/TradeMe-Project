package general.application;


import general.domain.Project;
import general.domain.Tradesman;
import general.domain.repository.MemberRepository;
import general.domain.repository.ProjectRepository;
import kernel.CommandHandler;

import java.util.Objects;

public final class RequestAssignTradesmanCommandHandler implements CommandHandler<RequestAssignTradesman, Void> {

    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    public RequestAssignTradesmanCommandHandler(ProjectRepository projectRepository, MemberRepository memberRepository) {
        this.projectRepository = Objects.requireNonNull(projectRepository);
        this.memberRepository = Objects.requireNonNull(memberRepository);

    }

    public Void handle(RequestAssignTradesman assignTradesman) {
        var memberId = assignTradesman.memberId;
       final Tradesman member = (Tradesman) memberRepository.findById(memberId);

       var projectId = assignTradesman.projectId;
       final Project project = projectRepository.findById(projectId);
       member.addProject(project);
       memberRepository.add(member);
        return null;
    }
}
