package com.jw.reservation.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Holiday {
	
	// 휴무일 식별번호
	private Long holiId;
	// 의사 식별번호
	private Long docId;
	// 휴무일
	private Timestamp holiDt;
	// 삭제 여부
	private String delYn;
	// 등록 일시
	private Timestamp regDt;
	// 수정 일시
	private Timestamp modDt;
}
