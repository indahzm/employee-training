package co.id.employeetraining.service;

import co.id.employeetraining.entity.RekeningEntity;
import co.id.employeetraining.entity.dto.ResponseDto;

public interface RekeningService {
	
	ResponseDto save(RekeningEntity rekening);
	ResponseDto findAll(Integer page, Integer size);
	ResponseDto findById(Long id);
	ResponseDto delete(Long id);
	
}
