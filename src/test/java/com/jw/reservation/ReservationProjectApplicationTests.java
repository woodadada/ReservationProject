package com.jw.reservation;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jw.reservation.constants.CodeConst;
import com.jw.reservation.form.ReservationForm;
import com.jw.reservation.model.Doctor;
import com.jw.reservation.model.Reservation;
import com.jw.reservation.service.DoctorService;
import com.jw.reservation.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ReservationProjectApplicationTests {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	ReservationService reservationService;
	
//	@Test
	public void insertDoctor() {
		Doctor d = new Doctor();
		d.setDocNm("강정우");
		d.setDocCd(CodeConst.DOCTOR_TP_CD_MEDICINE.getValue());
		d.setDelYn(CodeConst.BOOLEAN_FALSE.getValue());
		
		Integer i = doctorService.insertDoctor(d);
		
		log.info(i.toString());
	}
	
//	@Test
	public void updateDoctor() {
		Doctor d = new Doctor();
		long a = 2;
		d.setDocId(a);
		d.setDocNm("강정수");
		d.setDocCd(CodeConst.DOCTOR_TP_CD_ORTHO.getValue());
		d.setDelYn(CodeConst.BOOLEAN_FALSE.getValue());
		
		Integer i = doctorService.modifyDoctor(d);
		
		log.info(i.toString());
	}
	
	@Test
	public void test() {
		Date date = new Date(); 
		ReservationForm rf = new ReservationForm();
		rf.setRevDt(new Timestamp(date.getTime()));
		
		List<Reservation> list = reservationService.getList(rf);
		
		
		
		log.info(list.toString());
	}

}
