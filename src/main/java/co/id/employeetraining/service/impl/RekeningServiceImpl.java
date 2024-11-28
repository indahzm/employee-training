package co.id.employeetraining.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.id.employeetraining.entity.KaryawanEntity;
import co.id.employeetraining.entity.RekeningEntity;
import co.id.employeetraining.entity.dto.ResponseDto;
import co.id.employeetraining.entity.dto.ResponseConstant;
import co.id.employeetraining.repository.KaryawanRepository;
import co.id.employeetraining.repository.RekeningRepository;
import co.id.employeetraining.service.RekeningService;

@Service
@Transactional
public class RekeningServiceImpl implements RekeningService {

	@Autowired
	private RekeningRepository rekeningRepository;
	
	@Autowired
	private KaryawanRepository karyawanRepository;
	
	@Override
	public ResponseDto save(RekeningEntity rekening) {
		if (rekening.getId() != null) {
			RekeningEntity rekeningExist = rekeningRepository.findById(rekening.getId()).orElse(null);
			if(rekeningExist != null) {
				rekening.setCreatedDate(rekeningExist.getCreatedDate());
				if (!rekening.getKaryawan().getId().equals(rekeningExist.getKaryawan().getId())) {
					KaryawanEntity karyawan = getKaryawan(rekening.getKaryawan().getId());
					if (karyawan == null) {
						return new ResponseDto(ResponseConstant.STATUS_NOT_FOUD, ResponseConstant.DATA_NOT_FOUND.replace("${object}", "Karyawan"), 404);
					}
					rekening.setKaryawan(karyawan);
				} else {
					rekening.setKaryawan(rekeningExist.getKaryawan());
				}
			} else {
				return new ResponseDto(ResponseConstant.STATUS_NOT_FOUD, ResponseConstant.DATA_NOT_FOUND.replace("${object}", "Rekening"), 404);
			}
		} else {
			KaryawanEntity karyawan = getKaryawan(rekening.getKaryawan().getId());
			if (karyawan == null) {
				return new ResponseDto(ResponseConstant.STATUS_NOT_FOUD, ResponseConstant.DATA_NOT_FOUND.replace("${object}", "Karyawan"), 404);
			}
			rekening.setKaryawan(karyawan);
			rekening.setCreatedDate(new Date());
		}
		rekening.setUpdatedDate(new Date());
		rekening = rekeningRepository.save(rekening);
		return new ResponseDto(ResponseConstant.STATUS_SUKSES, rekening, 200);
	}
	
	private KaryawanEntity getKaryawan(Long id) {
		KaryawanEntity karyawan = karyawanRepository.findById(id).orElse(null);
		return karyawan;
	}
	
	@Override
	public ResponseDto findAll(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseDto(ResponseConstant.STATUS_SUKSES, rekeningRepository.findAll(pageable), 200);
	}

	@Override
	public ResponseDto findById(Long id) {
		RekeningEntity rekening = rekeningRepository.findById(id).orElse(null);
		if (rekening == null) {
			return new ResponseDto(ResponseConstant.STATUS_NOT_FOUD, ResponseConstant.DATA_NOT_FOUND.replace("${object}", "Rekening"), 404);
		}
		return new ResponseDto(ResponseConstant.STATUS_SUKSES, rekening, 200);	
	}

	@Override
	public ResponseDto delete(Long id) {
		RekeningEntity rekening = rekeningRepository.findById(id).orElse(null);
		if (rekening == null) {
			return new ResponseDto(ResponseConstant.STATUS_NOT_FOUD, ResponseConstant.DATA_NOT_FOUND.replace("${object}", "Rekening"), 404);
		}
		rekening.setDeletedDate(new Date());
		rekeningRepository.save(rekening);
		return new ResponseDto(ResponseConstant.STATUS_SUKSES, ResponseConstant.DATA_SUKSES, 200);
	}
	
}
