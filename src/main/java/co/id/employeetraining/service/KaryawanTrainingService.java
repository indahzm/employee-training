package co.id.employeetraining.service;

import co.id.employeetraining.entity.KaryawanTrainingEntity;
import co.id.employeetraining.entity.dto.ResponseDto;

public interface KaryawanTrainingService {

	ResponseDto save(KaryawanTrainingEntity karyawanTraining);
	ResponseDto findAll(Integer page, Integer size);
	ResponseDto findById(Long id);
	ResponseDto delete(Long id);
	
}
