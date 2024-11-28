package co.id.employeetraining.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.id.employeetraining.entity.KaryawanEntity;

@Repository
public interface KaryawanRepository extends PagingAndSortingRepository<KaryawanEntity, Long> {

	Optional<KaryawanEntity> findById(Long id);
	KaryawanEntity save(KaryawanEntity karyawan);
	Page<KaryawanEntity> findAll(Pageable pageable);
	
}
