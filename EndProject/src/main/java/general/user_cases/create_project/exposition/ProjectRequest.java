package general.user_cases.create_project.exposition;

import general.user_cases.create_project.domain.enums.Department;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

public final class ProjectRequest {

    @NotNull
    public String projectName;

    @NotNull
    public int contractorId;
    
    @NotNull
    public List<TaskRequest> tasks;

    @NotNull
    public Calendar startDate;

    @NotNull
    public Calendar endDate;

    @NotNull
    public Department location;

    @NotNull
    public int desiredDailyRate;

    @NotNull
    public int durationOfEngagementInDays;
    
}
