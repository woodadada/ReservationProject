package com.jw.reservation.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.reservation.form.ReservationForm;
import com.jw.reservation.model.Reservation;
import com.jw.reservation.repository.ReservationDao;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationDao reservationDao;
	
	/**
	 * 예약 목록
	 * @return
	 */
	public List<Reservation> getList(ReservationForm form) {
		return reservationDao.getList(form);
	}
	
	/**
	 * 예약 등록
	 * 각종 체크 필요
	 * 일단 예약 가능 여부를 통한 검사
	 * 해당 의사 존재 여부 등등
	 * @param reservation
	 * @return
	 */
	public Integer insertReservation(Reservation reservation) {
		/**
		 * 예약 가능 시간 부터 체크
		 * 예약 테이블 데이터에 해당 진료 코드, 진료 시작 시간, 진료 마감 시간을 넣고 시간, 진료 과목이 겹치는지 검사
		 */
		ReservationForm rf = new ReservationForm();
		rf.setDocCd(reservation.getDocCd());
		rf.setRevDt(reservation.getRevDt());
		rf.setRevStDt(reservation.getRevStDt());
		rf.setRevEndDt(reservation.getRevEndDt());
		List<Reservation> list = this.getList(rf);
		
		/**
		 * 진료 시간, 진료 과목이 겹치더라도 해당 진료 과목 의사가 여러명 일 수 있으므로 검사
		 * 시간,과목이 겹친다면 list가 리턴
		 * return list에 해당 예약 의사 식별 번호
		 * 해당 예약 의사 식별번호를 외의 진료 과목 의사 예약 검사, 휴무일 검사
		 * 문제 없다면 예약 insert
		 */
		
		// 진료 시간, 진료 과목이 겹치지 않아 등록 가능
//		if(list.isEmpty() && list.size() == 0) {
//			// 해당 진료 코드 의사가 휴무가 아닌지 검사
//		}
		
		return reservationDao.insert(reservation);
	}
	
	/**
	 * 예약 수정
	 * @param reservation
	 * @return
	 */
	public Integer modifyReservation(Reservation reservation) {
		return reservationDao.modify(reservation);
	}
	
	/**
	 * 예약 삭제
	 * @param reservation
	 * @return
	 */
	public Integer deleteReservation(Reservation reservation) {
		return reservationDao.modify(reservation);
	}
	
	/**
	 * 예약 가능 여부 확인
	 * 해당 일자 의사 존재 여부 등등
	 * @param reservation
	 * @return
	 */
	public Integer checkReservation(Reservation reservation) {
		return reservationDao.checkReservation(reservation);
	}
	
	public List<Reservation> getDoctorScheduleList(Reservation reservation) {
		return reservationDao.getReservationList(reservation);
	}
}
