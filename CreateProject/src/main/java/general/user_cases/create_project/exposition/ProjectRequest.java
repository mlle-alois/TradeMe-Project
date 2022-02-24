package general.user_cases.create_project.exposition;

import javax.validation.constraints.NotNull;

public final class ProjectRequest {

    @NotNull
    public String projectName;

    @NotNull
    public int contractorId;
    
}
