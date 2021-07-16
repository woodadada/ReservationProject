package com.jw.reservation.model;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class OperatingHours {
	
	// 진료 시간 식별 번호
	private Long opeId;
	// 진료 시작 시간
	private Date cncStDt;
	// 진료 마감 시간
	private Date cncEndDt;
	// 점심 시작 시간
	private Date lucStDt;
	// 점심 마감 시간
	private Date lucEndDt;
	// 날짜 구분 코드
	private String dayCd;
	// 날짜 구분 명
	private String dayCdNm;
	// 등록 일시
	private Timestamp regDt;
	// 수정 일시
	private Timestamp modDt;
}
