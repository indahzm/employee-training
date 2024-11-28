package co.id.employeetraining.service;

import co.id.employeetraining.entity.KaryawanEntity;
import co.id.employeetraining.entity.dto.ResponseDto;

public interface KaryawanService {
	
	ResponseDto save(KaryawanEntity karyawan);
	ResponseDto findAll(Integer page, Integer size);
	ResponseDto findById(Long id);
	ResponseDto delete(Long id);

}
