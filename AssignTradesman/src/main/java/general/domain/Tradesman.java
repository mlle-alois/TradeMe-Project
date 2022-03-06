package general.domain;


import general.domain.valueObjects.MemberId;
import general.domain.valueObjects.MemberName;

import java.util.ArrayList;
import java.util.List;

public final class Tradesman extends Member {

 private List<Project> projects = new ArrayList<Project>();

    private Tradesman(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        super(memberId, name, company,subscription);

    }

    public static Tradesman of(MemberId memberId, MemberName name, Company company,Subscription subscription) {
        return new Tradesman(memberId, name, company,subscription);
    }

    public void addProject(Project project){
        projects.add(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    @Override
    public String toString() {
        return "Tradesman{" + "name :"+ this.getName() +
                "projects=" + projects +
                '}';
    }
}
