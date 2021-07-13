package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class OperatingHours {
	
	// 운영시간 식별번호
	private Long opeId;
	// 진료 시작시간
	private Date cncStDt;
	// 진료 마감시간
	private Date cncEndDt;
	// 점심 시작시간
	private Date lucStDt;
	// 점심 마감시간
	private Date lucEndDt;
	// 날짜 구분 코드
	private String dayCd;
	// 날짜 구분 코드 명
	private String dayCdNm;
	// 등록 일시
	private Date regDt;
	// 수정 일시
	private Date modDt;
}
