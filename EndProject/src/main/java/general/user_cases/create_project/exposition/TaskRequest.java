package general.user_cases.create_project.exposition;

import general.user_cases.create_project.domain.enums.AptitudeCertificates;
import general.user_cases.create_project.domain.enums.Skills;
import general.user_cases.create_project.domain.enums.Speciality;

import javax.validation.constraints.NotNull;
import java.util.List;

public final class TaskRequest {

    @NotNull
    public String taskName;

    @NotNull
    public List<AptitudeCertificates> aptitudeCertificates;

    @NotNull
    public List<Speciality> specialities;

    @NotNull
    public List<Skills> skills;
    
    @NotNull
    public int durationInDays;
    
}
