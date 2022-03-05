package general.user_cases.create_project.application;

import general.kernel.Query;
import general.user_cases.create_project.domain.valueObjects.TradesmanId;

public class RetreveCertificates implements Query {

    public final TradesmanId tradesmanId;

    public RetreveCertificates(TradesmanId tradesmanId) {
        this.tradesmanId = tradesmanId;
    }
}
