package Covid19_project.Covid19_project.repository;

import Covid19_project.Covid19_project.model.covid19TrackerModel;
import org.springframework.data.repository.CrudRepository;

public interface covid19TrackerRepository extends CrudRepository<covid19TrackerModel, Integer> {
}
