package general.user_cases.apply_for_certificate.exposition;

import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;

import java.util.List;

public class CertificatesResponse {

 public final List<AptitudeCertificates> aptitudeCertificates;

    public CertificatesResponse(List<AptitudeCertificates> aptitudeCertificates) {
        this.aptitudeCertificates = aptitudeCertificates;
    }
}
