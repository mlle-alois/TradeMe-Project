package general.user_cases.apply_for_certificate.exposition;

import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;

public class CertificateResponse {

    public AptitudeCertificates aptitudeCertificates;

    public CertificateResponse(AptitudeCertificates aptitudeCertificates) {
        this.aptitudeCertificates = aptitudeCertificates;
    }

}
