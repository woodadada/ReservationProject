package com.jw.reservation.model;

import java.util.Date;

import lombok.Data;

@Data
public class OperatingHours {
	
	// ��ð� �ĺ���ȣ
	private Long opeId;
	// ���� ���۽ð�
	private Date cncStDt;
	// ���� �����ð�
	private Date cncEndDt;
	// ���� ���۽ð�
	private Date lucStDt;
	// ���� �����ð�
	private Date lucEndDt;
	// ��¥ ���� �ڵ�
	private String dayCd;
	// ��¥ ���� �ڵ� ��
	private String dayCdNm;
	// ��� �Ͻ�
	private Date regDt;
	// ���� �Ͻ�
	private Date modDt;
}
