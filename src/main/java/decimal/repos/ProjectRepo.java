package decimal.repos;

import decimal.enity.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepo extends CrudRepository<Project,Long>{
    List<Project> findByProjectName(String projectName);
}
