package general.user_cases.create_project.application;

import general.kernel.Command;
import general.user_cases.create_project.domain.Task;
import general.user_cases.create_project.domain.enums.Department;
import general.user_cases.create_project.domain.valueObjects.DailyRate;
import general.user_cases.create_project.domain.valueObjects.MemberId;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateProject implements Command {
    public final String projectName;
    public final MemberId responsible;
    public final List<Task> tasks;
    public final Calendar startDate;
    public final Calendar endDate;
    public final Department location;
    public final DailyRate desiredDailyRate;
    public final int durationOfEngagmentInDays;

    public CreateProject(String projectName, MemberId responsible, List<Task> tasks, Calendar startDate, Calendar endDate,
                         Department location, DailyRate desiredDailyRate, int durationOfEngagmentInDays) {
        this.projectName = Objects.requireNonNull(projectName);
        this.responsible = Objects.requireNonNull(responsible);
        this.tasks = Objects.requireNonNull(tasks);
        this.startDate = Objects.requireNonNull(startDate);
        this.endDate = Objects.requireNonNull(endDate);
        this.location = Objects.requireNonNull(location);
        this.desiredDailyRate = Objects.requireNonNull(desiredDailyRate);
        this.durationOfEngagmentInDays = durationOfEngagmentInDays;
    }
}
