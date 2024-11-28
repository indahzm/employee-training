package co.id.employeetraining.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.id.employeetraining.entity.KaryawanTrainingEntity;

@Repository
public interface KaryawanTrainingRepository extends PagingAndSortingRepository<KaryawanTrainingEntity, Long>{
	
	Optional<KaryawanTrainingEntity> findById(Long id);
	KaryawanTrainingEntity save(KaryawanTrainingEntity karyawanTraining);
	Page<KaryawanTrainingEntity> findAll(Pageable pageable);
	List<KaryawanTrainingEntity> findAllByKaryawanId(Long id);
	List<KaryawanTrainingEntity> findAllByTrainingId(Long id);
	void saveAll(Iterable<KaryawanTrainingEntity> karyawanTrainingList);
	
}
