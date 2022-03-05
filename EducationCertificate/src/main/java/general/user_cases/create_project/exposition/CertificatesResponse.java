package general.user_cases.create_project.exposition;

import general.user_cases.create_project.domain.enums.AptitudeCertificates;

import java.util.List;

public class CertificatesResponse {

 public final List<AptitudeCertificates> aptitudeCertificates;

    public CertificatesResponse(List<AptitudeCertificates> aptitudeCertificates) {
        this.aptitudeCertificates = aptitudeCertificates;
    }
}
