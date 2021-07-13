package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class Reservation {
	
	// 예약 식별번호
	private Long resId;
	// 환자 식별번호
	private Long mbrId;
	// 의사 식별번호
	private Long docId;
	
	// 진료일
	private Date resDt;
	// 진료 시작 일시
	private Date resStDt;
	// 진료 사용 시간
	private Date resMt;
	// 진료 마감 일시
	private Date resEndDt;
	
	// 삭제 여부
	private String delYn;
	// 등록 일시
	private Date regDt;
	// 수정 일시
	private Date modDt;
}
