package exposition;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

public final class ProjectRequest {

    @NotNull
    public String projectName;

    @NotNull
    public int contractorId;


    @NotNull
    public Calendar startDate;

    @NotNull
    public Calendar endDate;


    @NotNull
    public int durationOfEngagementInDays;
    
}
