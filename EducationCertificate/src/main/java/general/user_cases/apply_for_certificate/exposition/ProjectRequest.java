package general.user_cases.apply_for_certificate.exposition;

import general.user_cases.apply_for_certificate.domain.enums.Department;

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
