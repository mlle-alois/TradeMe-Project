package general.user_cases.create_project.domain.repository;

import general.kernel.Repository;
import general.user_cases.create_project.domain.Project;
import general.user_cases.create_project.domain.valueObjects.ProjectId;

import java.util.List;


public interface ProjectRepository extends Repository<ProjectId, Project> {    
    List<Project> findAll();
}
