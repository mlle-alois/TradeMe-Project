package general.user_cases.create_project.application;

import general.kernel.Event;
import general.user_cases.create_project.domain.Tradesman;
import general.user_cases.create_project.domain.enums.AptitudeCertificates;

public class ApplyForCertificateEvent implements Event {

    public final Tradesman tradesman;
    public final AptitudeCertificates aptitudeCertificates;

    public ApplyForCertificateEvent(Tradesman tradesman, AptitudeCertificates aptitudeCertificates){

        this.tradesman = tradesman;
        this.aptitudeCertificates = aptitudeCertificates;
    }
}
