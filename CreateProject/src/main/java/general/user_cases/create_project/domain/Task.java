package general.user_cases.create_project.domain;

import general.user_cases.create_project.domain.enums.AptitudeCertificates;
import general.user_cases.create_project.domain.enums.Skills;
import general.user_cases.create_project.domain.enums.Speciality;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Task {

    private final String name;
    private final List<Tradesman> tradesmansInCharge;
    private final List<AptitudeCertificates> requiredCertificates;
    private final List<Speciality> requiredSpecialities;
    private final List<Skills> requiredSkills;
    private final int durationInDays;
    private boolean isFinished;
    private final Project project;

    private Task(String name, List<AptitudeCertificates> requiredCertificates, List<Speciality> requiredSpecialities,
                 List<Skills> requiredSkills, int durationInDays, Project project) {
        this.name = Objects.requireNonNull(name);
        this.tradesmansInCharge = new ArrayList<>();
        this.requiredCertificates = Objects.requireNonNull(requiredCertificates);
        this.requiredSpecialities = requiredSpecialities;
        this.requiredSkills = Objects.requireNonNull(requiredSkills);
        this.durationInDays = durationInDays;
        this.isFinished = false;
        this.project = Objects.requireNonNull(project);
    }

    public static Task of(String name, List<AptitudeCertificates> requiredCertificates, List<Speciality> requiredSpecialities,
                          List<Skills> requiredSkills, int durationInDays, Project project) {
        return new Task(name, requiredCertificates, requiredSpecialities, requiredSkills, durationInDays, project);
    }

    public String getName() {
        return name;
    }

    public List<Tradesman> getTradesmansInCharge() {
        return tradesmansInCharge;
    }

    public List<AptitudeCertificates> getRequiredCertificates() {
        return requiredCertificates;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void finish() {
        this.isFinished = true;
    }

    public int getDurationInDays() {
        return durationInDays;
    }

    public Project getConstructProject() {
        return project;
    }

    public List<Speciality> getRequiredSpecialities() {
        return requiredSpecialities;
    }

    public List<Skills> getRequiredSkills() {
        return requiredSkills;
    }

    public Project getProject() {
        return project;
    }

    //TODO méthodes pour tradesmans

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name : ").append(name).append("\n");
        result.append("--- Tradesmans in charge : \n");
        for (Tradesman tradesman : tradesmansInCharge) {
            result.append(tradesman.toString()).append("\n");
        }
        result.append("--- Required certificates : \n");
        for (AptitudeCertificates aptitudeCertificate : requiredCertificates) {
            result.append(aptitudeCertificate).append("\n");
        }
        result.append("--- Required specialities : \n");
        for (Speciality speciality : requiredSpecialities) {
            result.append(speciality).append("\n");
        }
        result.append("--- Required skills : \n");
        for (Skills skill : requiredSkills) {
            result.append(skill).append("\n");
        }
        result.append("Duration : ").append(durationInDays).append(" days\n");
        result.append("Task is finished ? : ").append(isFinished).append("\n");
        result.append("Construct project : ").append(project.getProjectName()).append("\n");
        return result.toString();
    }
}
