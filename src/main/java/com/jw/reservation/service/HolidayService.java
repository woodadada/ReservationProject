package com.jw.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.reservation.constants.CodeConst;
import com.jw.reservation.form.ReservationForm;
import com.jw.reservation.model.Holiday;
import com.jw.reservation.model.Reservation;
import com.jw.reservation.repository.HolidayDao;

@Service
public class HolidayService {
	
	@Autowired
	private HolidayDao holidayDao;
	
	@Autowired
	private ReservationService reservationService;
	
	public Integer insertHoliday(Holiday holiday) {
		// 휴무일에 예약이 없을 때만 등록 가능
		ReservationForm rf = new ReservationForm();
		rf.setRevDt(holiday.getHoliDt());
		rf.setDocId(holiday.getDocId());
		List<Reservation> list = reservationService.getList(rf);
		
		if(list.isEmpty()) {
			holiday.setDelYn(CodeConst.BOOLEAN_FALSE.getValue());
			return holidayDao.insert(holiday); 
		}
		
		return 0;
	}
	
	public Integer deleteHoliday(Holiday holiday) {
		// 삭제 여부 Y
		holiday.setDelYn(CodeConst.BOOLEAN_TRUE.getValue());
		return holidayDao.modify(holiday);
	}
}
