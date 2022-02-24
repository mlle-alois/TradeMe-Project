package general.user_cases.create_project.application;

import general.kernel.Command;
import general.user_cases.create_project.domain.valueObjects.MemberId;

import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateProject implements Command {
    public final String projectName;
    public final MemberId responsible;

    public CreateProject(String projectName, MemberId responsible) {
        this.projectName = Objects.requireNonNull(projectName);
        this.responsible = Objects.requireNonNull(responsible);
    }
}
