package general.user_cases.apply_for_certificate.application;

import general.kernel.Command;
import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;
import general.user_cases.apply_for_certificate.domain.valueObjects.TradesmanId;


public class ModifyTradesmanCertificate implements Command {

    public final TradesmanId tradesmanId;
    public final AptitudeCertificates aptitudeCertificates;

    public ModifyTradesmanCertificate(TradesmanId tradesmanId, AptitudeCertificates aptitudeCertificates) {
        this.tradesmanId = tradesmanId;
        this.aptitudeCertificates = aptitudeCertificates;
    }
}
