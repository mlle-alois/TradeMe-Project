package general.user_cases.create_project.application;

import general.kernel.Command;
import general.user_cases.create_project.domain.enums.AptitudeCertificates;
import general.user_cases.create_project.domain.valueObjects.TradesmanId;


public class ModifyTradesmanCertificate implements Command {

    public final TradesmanId tradesmanId;
    public final AptitudeCertificates aptitudeCertificates;

    public ModifyTradesmanCertificate(TradesmanId tradesmanId, AptitudeCertificates aptitudeCertificates) {
        this.tradesmanId = tradesmanId;
        this.aptitudeCertificates = aptitudeCertificates;
    }
}
