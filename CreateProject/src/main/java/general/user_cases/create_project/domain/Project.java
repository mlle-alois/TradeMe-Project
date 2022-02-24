package general.user_cases.create_project.domain;

import general.user_cases.create_project.domain.enums.Department;
import general.user_cases.create_project.domain.enums.Status;
import general.user_cases.create_project.domain.valueObjects.DailyRate;
import general.user_cases.create_project.domain.valueObjects.ProjectId;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public final class Project {

    private final ProjectId projectId;
    private final String projectName;
    private final Contractor responsible;
    private final List<Task> tasks;
    private final Calendar startDate;
    private final Calendar endDate;
    private final Department location;
    private final DailyRate desiredDailyRate;
    private final int durationOfEngagmentInDays;
    private final Status status;

    private Project(ProjectId projectId, String projectName, Contractor responsible, List<Task> tasks, Calendar startDate, Calendar endDate,
                    Department location, DailyRate desiredDailyRate, int durationOfEngagmentInDays, Status status) {
        this.projectId = projectId;
        this.projectName = Objects.requireNonNull(projectName);
        this.responsible = Objects.requireNonNull(responsible);
        this.tasks = tasks;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.desiredDailyRate = desiredDailyRate;
        this.durationOfEngagmentInDays = durationOfEngagmentInDays;
        this.status = status;
    }

    /*public static Project of(String name, Contractor responsible, List<Task> tasks, Calendar startDate, Calendar endDate,
                             Department location, DailyRate desiredDailyRate, int durationOfEngagmentInDays, Status status) {
        return new Project(name, responsible, tasks, startDate, endDate, location, desiredDailyRate, durationOfEngagmentInDays, status);
    }*/

    public static Project emptyProject(ProjectId projectId, String projectName, Contractor responsible) {
        return new Project(projectId, projectName, responsible, new ArrayList<>(), null, null, null, null, 0, Status.CREATED);
    }

    public String getProjectName() {
        return projectName;
    }

    public Contractor getResponsible() {
        return responsible;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Department getLocation() {
        return location;
    }

    public DailyRate getDesiredDailyRate() {
        return desiredDailyRate;
    }

    public int getDurationOfEngagmentInDays() {
        return durationOfEngagmentInDays;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name : ").append(projectName).append("\n");
        result.append("Responsible : \n").append(responsible).append("\n");
        for (Task task : tasks) {
            result.append("------ Task : \n").append(task.toString()).append("\n");
        }
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        result.append("Start date : ").append(format.format(startDate.getTime())).append("\n");
        result.append("End date : ").append(format.format(endDate.getTime())).append("\n");
        result.append("Location : ").append(location).append("\n");
        result.append("Desired Daily Rate : ").append(desiredDailyRate).append("\n");
        result.append("Duration Of Engagment : ").append(durationOfEngagmentInDays).append(" days\n");
        return result.toString();
    }

    public Status getStatus() {
        return status;
    }

    public ProjectId getProjectId() {
        return projectId;
    }
}
