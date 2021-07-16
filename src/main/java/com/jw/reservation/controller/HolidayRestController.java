package com.jw.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jw.practice.model.Message;
import com.jw.reservation.constants.StatusCodeConst;
import com.jw.reservation.model.Holiday;
import com.jw.reservation.service.HolidayService;

@RestController
@RequestMapping("/holiday")
public class HolidayRestController {
	
	@Autowired
	private HolidayService holidayService; 
	
	/**
	 * 휴무일 등록
	 * @param holiday
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<Message> createHoliday(@RequestBody Holiday holiday){
		Integer flag = holidayService.insertHoliday(holiday);
		
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
	 * 휴무일 삭제
	 * @param holiday
	 * @return
	 */
	@PutMapping("")
	public ResponseEntity<Message> modifyHoliday(@RequestBody Holiday holiday){
		Integer flag = holidayService.deleteHoliday(holiday);
		
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
