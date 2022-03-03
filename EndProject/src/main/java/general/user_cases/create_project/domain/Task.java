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

    private Task(String name, List<AptitudeCertificates> requiredCertificates, List<Speciality> requiredSpecialities,
                 List<Skills> requiredSkills, int durationInDays) {
        this.name = Objects.requireNonNull(name);
        this.tradesmansInCharge = new ArrayList<>();
        this.requiredCertificates = Objects.requireNonNull(requiredCertificates);
        this.requiredSpecialities = requiredSpecialities;
        this.requiredSkills = Objects.requireNonNull(requiredSkills);
        this.durationInDays = durationInDays;
        this.isFinished = false;
    }

    public static Task of(String name, List<AptitudeCertificates> requiredCertificates, List<Speciality> requiredSpecialities,
                          List<Skills> requiredSkills, int durationInDays) {
        return new Task(name, requiredCertificates, requiredSpecialities, requiredSkills, durationInDays);
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

    public List<Speciality> getRequiredSpecialities() {
        return requiredSpecialities;
    }

    public List<Skills> getRequiredSkills() {
        return requiredSkills;
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
        return result.toString();
    }
}
