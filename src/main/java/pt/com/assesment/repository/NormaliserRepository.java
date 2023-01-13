package pt.com.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.assesment.domain.Normaliser;

public interface NormaliserRepository extends JpaRepository<Normaliser, Long>{
	
}
