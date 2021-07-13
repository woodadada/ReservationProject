package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class Doctor {
	
	// 의사 식별번호
	private Long docId;
	// 의사 이름
	private String docNm;
	// 의사 진료 타입
	private String docTpCd;
	// 의사 진료 타입 명
	private String docTpCdNm;
	// 삭제 여부
	private String delYn;
	// 등록 일시
	private Date regDt;
	// 수정 일시
	private Date modDt;
}
