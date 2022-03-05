package general.user_cases.apply_for_certificate.application;

import general.kernel.Command;
import general.user_cases.apply_for_certificate.domain.Tradesman;
import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;

public class ApplyForCertificate implements Command {

    public final Tradesman tradesman;
    public final AptitudeCertificates aptitudeCertificates;
    public boolean applicationStatus;

    public ApplyForCertificate(Tradesman tradesman, AptitudeCertificates aptitudeCertificates) {
        this.tradesman = tradesman;
        this.aptitudeCertificates = aptitudeCertificates;
        this.applicationStatus = false;
    }

    public void acceptApplication(){
        this.applicationStatus = true;
    }
}
