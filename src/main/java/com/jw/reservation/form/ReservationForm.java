package com.jw.reservation.form;

import java.sql.Timestamp;

import com.jw.reservation.constants.CodeConst;

import lombok.Data;

@Data
public class ReservationForm {
	
	// 예약 식별 번호
	private Long resId;
	// 환자 식별 번호
	private Long mbrId;
	// 의사 식별 번호
	private Long docId;
	// 삭제 여부
	private String delYn = CodeConst.BOOLEAN_FALSE.getValue();
	// 의사 진료 코드
	private String docCd;
	// 진료일
	private Timestamp revDt;
	// 진료 시작 시간
	private Timestamp revStDt;
	// 진료 마감 시간
	private Timestamp revEndDt;
}
