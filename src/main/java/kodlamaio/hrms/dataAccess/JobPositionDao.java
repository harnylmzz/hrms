package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosition;
@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

}
