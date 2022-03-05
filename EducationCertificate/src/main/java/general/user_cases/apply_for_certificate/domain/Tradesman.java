package general.user_cases.apply_for_certificate.domain;

import general.kernel.Entity;
import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;
import general.user_cases.apply_for_certificate.domain.enums.Skills;
import general.user_cases.apply_for_certificate.domain.enums.Speciality;
import general.user_cases.apply_for_certificate.domain.valueObjects.DailyRate;
import general.user_cases.apply_for_certificate.domain.valueObjects.TradesmanId;

import java.util.List;
import java.util.Objects;

public  class Tradesman implements Entity<TradesmanId> {

    private final TradesmanId tradesmanId;
    private final Speciality speciality;
    private final List<AptitudeCertificates> aptitudeCertificates;
    private final List<Skills> skills;
    private final GeographicZone geographicZone;
    private final DailyRate dailyRate;

    private Tradesman(TradesmanId tradesmanId,
                       Speciality speciality, List<AptitudeCertificates> aptitudeCertificates,
                      List<Skills> skills, GeographicZone geographicZone, DailyRate dailyRate) {
        this.tradesmanId = tradesmanId;
        this.speciality = Objects.requireNonNull(speciality);
        this.aptitudeCertificates = Objects.requireNonNull(aptitudeCertificates);
        this.skills = Objects.requireNonNull(skills);
        this.geographicZone = Objects.requireNonNull(geographicZone);
        this.dailyRate = Objects.requireNonNull(dailyRate);
    }

    public static Tradesman of(
                               TradesmanId tradesmanId,
                               Speciality speciality, List<AptitudeCertificates> aptitudeCertificates,
                               List<Skills> skills, GeographicZone geographicZone, DailyRate dailyRate) {
        return new Tradesman(tradesmanId, speciality, aptitudeCertificates, skills, geographicZone, dailyRate);
    }

    public TradesmanId getTradesmanId(){
        return tradesmanId;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public List<AptitudeCertificates> getAptitudeCertificates() {
        return aptitudeCertificates;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public GeographicZone getGeographicZone() {
        return geographicZone;
    }

    public DailyRate getDailyRate() {
        return dailyRate;
    }

    public void addCertificate(AptitudeCertificates aptitudeCertificates){
        this.aptitudeCertificates.add(aptitudeCertificates);

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString()).append("\n");
        result.append("-- Aptitude certificates : \n");
        for (AptitudeCertificates aptitudeCertificate : aptitudeCertificates) {
            result.append(aptitudeCertificate).append("\n");
        }
        result.append("-- Skills : \n").append(toStringSkills()).append("\n");
        result.append("-- Geographic zone : \n").append(geographicZone.toString()).append("\n");
        result.append("-- Daily rate : ").append(dailyRate.toString()).append("\n");
        return result.toString();
    }

    public String toStringSkills() {
        StringBuilder result = new StringBuilder();
        for (Skills skill : skills) {
            result.append("- ").append(skill).append("\n");
        }
        return result.toString();
    }

    @Override
    public TradesmanId id() {
        return tradesmanId;
    }
}
