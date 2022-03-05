package general.user_cases.apply_for_certificate.exposition;

import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;
import general.user_cases.apply_for_certificate.domain.enums.Skills;
import general.user_cases.apply_for_certificate.domain.enums.Speciality;

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
