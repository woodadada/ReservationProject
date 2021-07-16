package com.jw.reservation.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Doctor {
	
	// 의사 식별번호
	private Long docId;
	// 의사 이름
	private String docNm;
	// 의사 진료 코드
	private String docCd;
	// 의사 진료 코드 명 
	private String docCdNm;
	// 삭제 여부
	private String delYn;
	// 등록 일시
	private Timestamp regDt;
	// 수정 일시
	private Timestamp modDt;
}
