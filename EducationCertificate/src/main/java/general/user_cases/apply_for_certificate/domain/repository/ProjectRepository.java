package general.user_cases.apply_for_certificate.domain.repository;

import general.kernel.Repository;
import general.user_cases.apply_for_certificate.domain.Project;
import general.user_cases.apply_for_certificate.domain.valueObjects.ProjectId;

import java.util.List;


public interface ProjectRepository extends Repository<ProjectId, Project> {    
    List<Project> findAll();
}
