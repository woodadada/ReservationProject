package com.jw.reservation.controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jw.practice.model.Message;
import com.jw.reservation.constants.StatusCodeConst;
import com.jw.reservation.form.ReservationForm;
import com.jw.reservation.model.Reservation;
import com.jw.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationRestController {
	/**
	 * 전체 예약 조회
	 * 예약 생성
	 * 예약 취소
	 * 예약 가능 시간 확인
	 */
	
	@Autowired
	private ReservationService reservationService;
	
	/**
	 * 병원 전체 예약 조회
	 * @param date ex) 20210716
	 * @return
	 */
	@GetMapping("/day/{date}")
	public ResponseEntity<Message> getReservationList(
			@PathVariable("date")
			@DateTimeFormat(pattern="yyyyMMdd") Date date){
		
		ReservationForm rf = new ReservationForm();
		rf.setRevDt(new Timestamp(date.getTime()));
		List<Reservation> list = reservationService.getList(rf);
		
		Message ms = new Message();
		if(!list.isEmpty()) {
			ms.setStatus(StatusCodeConst.OK);
			ms.setData(list);
			return new ResponseEntity<Message>(ms, HttpStatus.CREATED);
		}else {
			ms.setStatus(StatusCodeConst.NOT_FOUND);
			return new ResponseEntity<Message>(ms, HttpStatus.NOT_FOUND);
		}
				
	}
	
	/**
	 * 의사 스케쥴 조회
	 * @param docId ex) 3
	 * @param date ex) 20210716
	 * @return
	 */
	@GetMapping("/doctor/{docId}/schedule/{date}")
	public ResponseEntity<Message> getDoctorScheduleList(
			@PathVariable Long docId,
			@PathVariable("date")
			@DateTimeFormat(pattern="yyyyMMdd") Date date){
		
		ReservationForm rf = new ReservationForm();
		rf.setRevDt(new Timestamp(date.getTime()));
		rf.setDocId(docId);
		List<Reservation> list = reservationService.getList(rf);
		
		Message ms = new Message();
		if(!list.isEmpty()) {
			ms.setStatus(StatusCodeConst.OK);
			ms.setData(list);
			return new ResponseEntity<Message>(ms, HttpStatus.CREATED);
		}else {
			ms.setStatus(StatusCodeConst.NOT_FOUND);
			return new ResponseEntity<Message>(ms, HttpStatus.NOT_FOUND);
		}
				
	}
	
	/**
	 * 
	 * @param docId
	 * @param date
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<Message> createReservation(@RequestBody Reservation reservation){
		
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(reservation.getRevStDt().getTime());
		cal.add(Calendar.SECOND, Integer.parseInt(reservation.getRevMt()));
		reservation.setRevEndDt(new Timestamp(cal.getTime().getTime()));
		
		reservationService.insertReservation(reservation);
		
		Message ms = new Message();
		
			return new ResponseEntity<Message>(ms, HttpStatus.CREATED);
				
	}
	
//	@PostMapping("")
//	public ResponseEntity<Message> createReservation(@RequestBody Reservation reservation){
//		Integer flag = doctorService.insertDoctor(doctor);
//		
//		Message ms = new Message();
//		
//		if(flag > 0) {
//			ms.setStatus(StatusCodeConst.OK);
//			return new ResponseEntity<Message>(ms, HttpStatus.CREATED);
//		}else {
//			ms.setStatus(StatusCodeConst.NOT_FOUND);
//			return new ResponseEntity<Message>(ms, HttpStatus.NOT_FOUND);
//		}		
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Message> deleteDoctor(@PathVariable Long id){
//		
//		Integer flag = doctorService.deleteDoctor(id);
//		
//		Message ms = new Message();
//		
//		if(flag > 0) {
//			ms.setStatus(StatusCodeConst.OK);
//			return new ResponseEntity<Message>(ms, HttpStatus.OK);
//		}else {
//			ms.setStatus(StatusCodeConst.NOT_FOUND);
//			return new ResponseEntity<Message>(ms, HttpStatus.NOT_FOUND);
//		}		
//	}
}
