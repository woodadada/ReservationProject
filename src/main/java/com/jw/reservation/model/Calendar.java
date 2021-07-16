package com.jw.reservation.model;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class Calendar {
	
	// 일자
	private Date de;
	// 요일
	private Integer dwk;
	// 휴일여부
	private String hoilYn;
	// 명절 당일 여부
	private String hldyYn;
	// 비고
	private String note;
	// 일시
	private Timestamp regDt;
}
