package general.user_cases.assign_tradesman.domain.repository;

import general.kernel.Repository;
import general.user_cases.assign_tradesman.domain.Project;
import general.user_cases.assign_tradesman.domain.valueObjects.ProjectId;

import java.util.List;


public interface ProjectRepository extends Repository<ProjectId, Project> {    
    List<Project> findAll();
}
