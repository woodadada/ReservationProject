package com.jw.reservation.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Reservation {
	
	// 예약 식별 번호
	private Long resId;
	// 환자 식별 번호
	private Long mbrId;
	// 의사 식별 번호
	private Long docId;
	
	// 진료일
	private Timestamp revDt;
	// 진료 시작 시간
	private Timestamp revStDt;
	// 진료 사용 시간
	private String revMt;
	// 진료 마감 시간
	private Timestamp revEndDt;
	
	// 삭제 여부
	private String delYn;
	// 등록 일시
	private Timestamp regDt;
	// 수정 일시
	private Timestamp modDt;
	
	// 의사 이름
	private String docNm;
	// 의사 진료 코드
	private String docCd;
	// 환자 이름
	private String mbrNm;
	// 환자 전화번호
	private String mbrCpNo;
}
