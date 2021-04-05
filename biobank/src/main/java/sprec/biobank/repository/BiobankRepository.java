package sprec.biobank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import sprec.biobank.domain.Biobank;

public interface BiobankRepository extends CrudRepository<Biobank, Integer> {
	public Iterable<Biobank> findByName(String name);
	public Optional<Biobank> findById(Integer id);
	public void deleteById(Integer id);
}
