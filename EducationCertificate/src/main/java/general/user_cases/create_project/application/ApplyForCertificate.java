package general.user_cases.create_project.application;

import general.kernel.Command;
import general.user_cases.create_project.domain.Tradesman;
import general.user_cases.create_project.domain.enums.AptitudeCertificates;

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
