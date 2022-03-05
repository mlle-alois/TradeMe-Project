package general.user_cases.apply_for_certificate.application;

import general.kernel.Query;
import general.user_cases.apply_for_certificate.domain.valueObjects.TradesmanId;

public class RetreveCertificates implements Query {

    public final TradesmanId tradesmanId;

    public RetreveCertificates(TradesmanId tradesmanId) {
        this.tradesmanId = tradesmanId;
    }
}
