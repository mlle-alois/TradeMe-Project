package general.infrastructure;


import general.domain.Project;
import general.domain.repository.ProjectRepository;
import general.domain.valueObjects.ProjectId;
import kernel.exception.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryProjectRepository implements ProjectRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<ProjectId, Project> data = new ConcurrentHashMap<>();

    @Override
    public List<Project> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public ProjectId nextIdentity() {
        return ProjectId.of(count.incrementAndGet());
    }

    @Override
    public Project findById(ProjectId id) throws NoSuchEntityException {
        final Project project = data.get(id);
        if (project == null) {
            throw NoSuchEntityException.withId(id);
        }
        return project;
    }

    @Override
    public void add(Project project) {
        data.put(project.getProjectId(), project);
    }

    @Override
    public void delete(ProjectId id) {
        data.remove(id);
    }
}
