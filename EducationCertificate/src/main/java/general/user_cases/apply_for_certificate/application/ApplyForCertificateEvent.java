package general.user_cases.apply_for_certificate.application;

import general.kernel.Event;
import general.user_cases.apply_for_certificate.domain.Tradesman;
import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;

public class ApplyForCertificateEvent implements Event {

    public final Tradesman tradesman;
    public final AptitudeCertificates aptitudeCertificates;

    public ApplyForCertificateEvent(Tradesman tradesman, AptitudeCertificates aptitudeCertificates){

        this.tradesman = tradesman;
        this.aptitudeCertificates = aptitudeCertificates;
    }
}
