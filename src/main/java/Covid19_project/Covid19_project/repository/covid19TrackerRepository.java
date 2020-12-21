package Covid19_project.Covid19_project.repository;

import Covid19_project.Covid19_project.model.covid19TrackerModel;
import org.springframework.data.repository.CrudRepository;

// The repository will retrieve and store all the data. 
// This will automatically read and save data from PostgreSQL
public interface covid19TrackerRepository extends CrudRepository<covid19TrackerModel, Integer> {
}
