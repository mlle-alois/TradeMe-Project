package general.application;


import general.domain.Project;
import general.domain.Tradesman;
import kernel.Command;

import java.util.List;

public class ApplyForProject implements Command {

    public final Tradesman tradesman;
    public final Project project;
    public boolean isAvailable;

    public ApplyForProject(Tradesman tradesman, Project project) {
        this.tradesman = tradesman;
        this.project = project;
        this.isAvailable = true;
    }

    public boolean IsTrademanAvailable(){
        List<Project> projects = tradesman.getProjects();
        if(projects.isEmpty())
            this.isAvailable = true;
        if(projects.contains(project))
            this.isAvailable = false;
        projects.forEach(project -> {
         if(this.isDateInvalid(project))
                 this.isAvailable = false;
        });
    return this.isAvailable;
    }

    private boolean isDateInvalid(Project project){
        return (project.getEndDate().compareTo(this.project.getStartDate())> 0) && (project.getStartDate().compareTo(this.project.getEndDate())< 0);
    }
}
