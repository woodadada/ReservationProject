package com.jw.reservation.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Member {
	
	// 환자 식별번호
	private Long mbrId;
	// 환자 이름
	private String mbrNm;
	// 환자 전화번호
	private String mbrCpNo;
	// 등록 일시
	private Timestamp regDt;
	// 수정 일시
	private Timestamp modDt;
}
