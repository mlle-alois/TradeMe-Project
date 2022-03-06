package general.application;


import general.domain.Project;
import general.domain.Tradesman;
import kernel.Event;

public class ApplyForProjectEvent implements Event {

    public final Tradesman tradesman;
    public final Project project;

    public ApplyForProjectEvent(Tradesman tradesman, Project project){

        this.tradesman = tradesman;
        this.project = project;
    }
}
