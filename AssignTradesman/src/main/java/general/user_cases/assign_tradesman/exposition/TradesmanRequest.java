package general.user_cases.assign_tradesman.exposition;

import javax.validation.constraints.NotNull;

public final class TradesmanRequest {

    @NotNull
    public int projectId;

    @NotNull
    public int tradesmanId;

    
}
