package com.jw.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.reservation.constants.CodeConst;
import com.jw.reservation.model.Doctor;
import com.jw.reservation.repository.DoctorDao;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorDao doctorDao;
	
	public Integer insertDoctor(Doctor doctor) {
		doctor.setDelYn(CodeConst.BOOLEAN_FALSE.getValue());
		return doctorDao.insert(doctor);
	}
	
	public Integer modifyDoctor(Doctor doctor) {
		return doctorDao.modify(doctor);
	}
	
	public Integer deleteDoctor(Long docId) {
		Doctor doctor = new Doctor();
		doctor.setDocId(docId);
		doctor.setDelYn(CodeConst.BOOLEAN_TRUE.getValue());
		try {
			Integer flag = doctorDao.modify(doctor);
			// 의사 삭제 성공 시 해당 의사 예약 삭제 처리
			if(flag > 0) {
				
			}
		} catch (Exception e) {
			
		}
		
		return doctorDao.modify(doctor);
	}
	
}
