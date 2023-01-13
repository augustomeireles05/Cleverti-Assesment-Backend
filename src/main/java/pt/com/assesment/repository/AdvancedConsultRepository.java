package pt.com.assesment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pt.com.assesment.domain.Normaliser;

public interface AdvancedConsultRepository extends JpaRepository<Normaliser, Long>{

	@Query("SELECT n FROM Normaliser n WHERE n.jobName LIKE %:jobName%")
	List<Normaliser> getByJobName(@Param("jobName") String jobName);

}
