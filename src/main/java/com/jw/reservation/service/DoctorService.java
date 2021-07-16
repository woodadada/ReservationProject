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
		
		return doctorDao.modify(doctor);
	}
	
}
