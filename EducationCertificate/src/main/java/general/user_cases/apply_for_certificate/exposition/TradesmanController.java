package general.user_cases.apply_for_certificate.exposition;

import general.user_cases.apply_for_certificate.application.RetreveCertificates;
import general.user_cases.apply_for_certificate.application.RetreveCertificatesCommandHandler;
import general.user_cases.apply_for_certificate.domain.enums.AptitudeCertificates;
import general.user_cases.apply_for_certificate.domain.valueObjects.TradesmanId;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tradesman")
public class TradesmanController {

    private final RetreveCertificatesCommandHandler retreveCertificatesCommandHandler;

    public TradesmanController(RetreveCertificatesCommandHandler retreveCertificatesCommandHandler) {
        this.retreveCertificatesCommandHandler = retreveCertificatesCommandHandler;
    }


    @GetMapping(path = "/certificates/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<CertificatesResponse> getCertificatesById(@PathVariable("id") TradesmanId id) {
        final List<AptitudeCertificates> certificates = retreveCertificatesCommandHandler.handle(new RetreveCertificates(id));
        CertificatesResponse certificatesResponse = new CertificatesResponse(certificates);
        return ResponseEntity.ok(certificatesResponse);
    }

}
