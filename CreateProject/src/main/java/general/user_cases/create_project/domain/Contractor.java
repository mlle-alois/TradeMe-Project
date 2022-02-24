package general.user_cases.create_project.domain;

import general.user_cases.create_project.domain.valueObjects.MemberId;
import general.user_cases.create_project.domain.valueObjects.MemberName;

import java.util.ArrayList;
import java.util.List;

public final class Contractor extends Member {

    private final List<Project> projects;

    private Contractor(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        super(memberId, name, company, subscription);
        this.projects = new ArrayList<>();
    }

    public static Contractor of(MemberId memberId, MemberName name, Company company, Subscription subscription) {
        return new Contractor(memberId, name, company, subscription);
    }

    public List<Project> getConstructProjects() {
        return projects;
    }

    public String toStringProjects() {
        StringBuilder result = new StringBuilder();
        for (Project project : projects) {
            result.append("------------ Project : \n").append(project.toString()).append("\n");
        }
        return result.toString();
    }
}
