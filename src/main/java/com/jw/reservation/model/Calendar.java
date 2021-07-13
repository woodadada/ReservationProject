package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class Calendar {
	
	// 일자
	private Date de;
	// 년월일
	private String ymd;
	// 연도
	private Integer yr;
	// 월
	private Integer mt;
	// 일
	private Integer dy;
	// 요일
	private Integer dwk;
	// 휴일여부
	private String hoilYn;
	// 명절당일 여부
	private String hldyYn;
	// 비고
	private String note;
	// 등록 일시
	private Date regDt;
}
