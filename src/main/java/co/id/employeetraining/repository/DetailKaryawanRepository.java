package co.id.employeetraining.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import co.id.employeetraining.entity.DetailKaryawanEntity;

@Repository
public interface DetailKaryawanRepository extends PagingAndSortingRepository<DetailKaryawanEntity, Long> {

	DetailKaryawanEntity save(DetailKaryawanEntity detailKaryawan);
	
}
