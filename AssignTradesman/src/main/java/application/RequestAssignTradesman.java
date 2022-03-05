package application;

import kernel.Command;
import domain.valueObjects.MemberId;

import java.util.Calendar;
import java.util.Objects;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class RequestAssignTradesman implements Command {
    public final String projectName;
    public final MemberId memberId;
    public final Calendar startDate;
    public final Calendar endDate;
    public final int durationOfEngagmentInDays;

    public RequestAssignTradesman(String projectName, MemberId responsible, Calendar startDate, Calendar endDate,
                                  int durationOfEngagmentInDays) {
        this.projectName = Objects.requireNonNull(projectName);
        this.memberId = Objects.requireNonNull(responsible);
        this.startDate = Objects.requireNonNull(startDate);
        this.endDate = Objects.requireNonNull(endDate);
        this.durationOfEngagmentInDays = durationOfEngagmentInDays;
    }
}
