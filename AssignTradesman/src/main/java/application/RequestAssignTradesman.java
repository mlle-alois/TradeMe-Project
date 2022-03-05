package application;

import domain.Project;
import domain.Tradesman;
import kernel.Command;
import domain.valueObjects.MemberId;

import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class RequestAssignTradesman implements Command {
    public final Project project;
    public final MemberId memberId;


    public RequestAssignTradesman(Project projectName, MemberId memberId) {
        this.project = Objects.requireNonNull(projectName);
        this.memberId = Objects.requireNonNull(memberId);

    }
}
