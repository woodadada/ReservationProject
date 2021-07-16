package com.jw.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jw.reservation.constants.StatusCodeConst;
import com.jw.reservation.model.Doctor;
import com.jw.reservation.model.Message;
import com.jw.reservation.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorRestController {
	
	
	@Autowired
	private DoctorService doctorService;
	
	/**
	 * 의사 등록
	 * @param doctor
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<Message> createDoctor(@RequestBody Doctor doctor){
		Integer flag = doctorService.insertDoctor(doctor);
		
		Message ms = new Message();
		
		if(flag > 0) {
			ms.setStatus(StatusCodeConst.OK);
			return new ResponseEntity<Message>(ms, HttpStatus.CREATED);
		}else {
			ms.setStatus(StatusCodeConst.NOT_FOUND);
			return new ResponseEntity<Message>(ms, HttpStatus.NOT_FOUND);
		}		
	}
	
	/**
	 * 의사 수정
	 * @param id
	 * @param doctor
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Message> modifyDoctor(@PathVariable Long id, @RequestBody Doctor doctor){
		doctor.setDocId(id);
		Integer flag = doctorService.modifyDoctor(doctor);
		
		Message ms = new Message();
		
		if(flag > 0) {
			ms.setStatus(StatusCodeConst.OK);
			return new ResponseEntity<Message>(ms, HttpStatus.OK);
		}else {
			ms.setStatus(StatusCodeConst.NOT_FOUND);
			return new ResponseEntity<Message>(ms, HttpStatus.NOT_FOUND);
		}		
	}
	
	/**
	 * 의사 삭제
	 * 해당 의사에게 생성된 예약 같이 삭제 처리
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Message> deleteDoctor(@PathVariable Long id){
		
		Integer flag = doctorService.deleteDoctor(id);
		
		Message ms = new Message();
		
		if(flag > 0) {
			ms.setStatus(StatusCodeConst.OK);
			return new ResponseEntity<Message>(ms, HttpStatus.OK);
		}else {
			ms.setStatus(StatusCodeConst.NOT_FOUND);
			return new ResponseEntity<Message>(ms, HttpStatus.NOT_FOUND);
		}		
	}
}
