package general.domain.repository;


import general.domain.Project;
import general.domain.valueObjects.ProjectId;
import kernel.Repository;

import java.util.List;

public interface ProjectRepository extends Repository<ProjectId, Project> {
    List<Project> findAll();
}
