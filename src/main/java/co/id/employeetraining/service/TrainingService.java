package co.id.employeetraining.service;

import co.id.employeetraining.entity.TrainingEntity;
import co.id.employeetraining.entity.dto.ResponseDto;

public interface TrainingService {

	ResponseDto save(TrainingEntity training);
	ResponseDto findAll(Integer page, Integer size);
	ResponseDto findById(Long id);
	ResponseDto delete(Long id);
	
}