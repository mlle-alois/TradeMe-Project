package general.domain;


import general.domain.enums.Status;
import general.domain.valueObjects.ProjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public final class Project {

    private final ProjectId projectId;
    private final String projectName;
    private final Calendar startDate;
    private final Calendar endDate;
    private final Status status;

    private Project(ProjectId projectId, String projectName, Calendar startDate, Calendar endDate, Status status) {
        this.projectId = projectId;
        this.projectName = Objects.requireNonNull(projectName);
        this.startDate = Objects.requireNonNull(startDate);
        this.endDate = Objects.requireNonNull(endDate);
        this.status = Objects.requireNonNull(status);
    }

    public static Project of(ProjectId projectId,String name, Calendar startDate, Calendar endDate,
                                Status status) {
        return new Project(projectId,name, startDate, endDate,  status);
    }

    public static Project emptyProject(ProjectId projectId, String projectName,
                                        Calendar startDate, Calendar endDate) {
        return new Project(projectId, projectName, startDate, endDate, Status.ACTIVATED);
    }

    public String getProjectName() {
        return projectName;
    }



    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }




    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name : ").append(projectName).append("\n");
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        result.append("Start date : ").append(format.format(startDate.getTime())).append("\n");
        result.append("End date : ").append(format.format(endDate.getTime())).append("\n");
        return result.toString();
    }

    public Status getStatus() {
        return status;
    }

    public ProjectId getProjectId() {
        return projectId;
    }
}
