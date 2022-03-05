package domain.repository;

import kernel.Repository;
import domain.Project;
import domain.valueObjects.ProjectId;

import java.util.List;


public interface ProjectRepository extends Repository<ProjectId, Project> {    
    List<Project> findAll();
}
