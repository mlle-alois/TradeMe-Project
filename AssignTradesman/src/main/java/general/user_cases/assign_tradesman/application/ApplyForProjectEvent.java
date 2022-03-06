package general.user_cases.assign_tradesman.application;

import general.kernel.Event;
import general.user_cases.assign_tradesman.domain.Project;
import general.user_cases.assign_tradesman.domain.Tradesman;

public class ApplyForProjectEvent implements Event {

    public final Tradesman tradesman;
    public final Project project;

    public ApplyForProjectEvent(Tradesman tradesman, Project project){

        this.tradesman = tradesman;
        this.project = project;
    }
}
